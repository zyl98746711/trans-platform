package com.zyl.transapp.configration;

import com.zyl.common.log.AppLogger;
import com.zyl.transapp.configration.wrapper.OkHttpClientWrapper;
import okhttp3.*;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * okHttp 配置
 *
 * @author zyl
 */
public class HttpConfiguration {

    /**
     * OkHttp 线程池配置
     *
     * @return okHttpClient
     */
    @Bean
    public OkHttpClientWrapper okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(5, 10, TimeUnit.MINUTES))
                .build();
        okHttpClient.interceptors().add(chain -> {
            long startTime = System.currentTimeMillis();
            Request request = chain.request();
            Response response = chain.proceed(request);
            long endTime = System.currentTimeMillis();
            HttpUrl url = request.url();
            String time = String.valueOf(endTime - startTime);
            AppLogger.log("url: %s, time: %s", url, time);
            return response;
        });
        return new OkHttpClientWrapper(okHttpClient);
    }
}
