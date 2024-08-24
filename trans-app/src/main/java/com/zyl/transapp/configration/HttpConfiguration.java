package com.zyl.transapp.configration;

import com.zyl.transapp.configration.wrapper.OkHttpClientWrapper;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

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
        return new OkHttpClientWrapper(okHttpClient);
    }
}
