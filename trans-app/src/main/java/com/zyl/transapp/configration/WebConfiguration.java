package com.zyl.transapp.configration;

import com.zyl.common.exception.BusinessException;
import com.zyl.common.web.EmptyMeta;
import com.zyl.common.web.ResponseBody;
import com.zyl.utils.JwtUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * web配置类
 *
 * @author zyl
 */
@Configuration
public class WebConfiguration {

    @Value("${token.sign}")
    private String sign;

    @ConditionalOnProperty(prefix = "web", name = "advice-exception", havingValue = "true", matchIfMissing = true)
    @RestControllerAdvice
    static class RestControllerExceptionAdvice {

        @ExceptionHandler(BusinessException.class)
        public ResponseBody<Void, EmptyMeta> businessExceptionHandler(BusinessException exception) {
            return ResponseBody.fail(exception.getMessage());
        }

        @ExceptionHandler(RuntimeException.class)
        public ResponseBody<Void, EmptyMeta> runtimeExceptionHandler(RuntimeException exception) {
            return ResponseBody.fail(exception.getMessage());
        }
    }


    public class JWTInterceptors implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
            String token = req.getHeader("token");
            if (StringUtils.isBlank(token)) {
                throw new RuntimeException("token is blank");
            }
            if (!JwtUtils.validate(token, sign)) {
                throw new RuntimeException("token is wrong!");
            }
            return Boolean.TRUE;
        }
    }

    @Configuration
    class InterceptorConfig implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new JWTInterceptors())
                    .addPathPatterns("/**")
                    .excludePathPatterns("/merchants/login");
        }
    }
}
