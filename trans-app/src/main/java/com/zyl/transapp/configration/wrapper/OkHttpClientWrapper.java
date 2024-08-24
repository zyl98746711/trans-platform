package com.zyl.transapp.configration.wrapper;

import com.zyl.common.web.HttpResponse;
import com.zyl.utils.JsonUtils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * OkHttpClient 封装
 *
 * @author zyl
 */
public class OkHttpClientWrapper extends OkHttpClient {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient okHttpClient;

    public OkHttpClientWrapper(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public <T, R> HttpResponse<R> doPost(String url, T req, Class<R> responseClass) {
        String body = JsonUtils.objToStr(req);
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, body);
        Call call = okHttpClient.newCall(new Request.Builder().url(url)
                .post(requestBody)
                .build());
        return executeAndResponse(responseClass, call);
    }


    public <T, R> HttpResponse<R> doPut(String url, T req, Class<R> responseClass) {
        String body = JsonUtils.objToStr(req);
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE, body);
        Call call = okHttpClient.newCall(new Request.Builder().url(url)
                .put(requestBody)
                .build());
        return executeAndResponse(responseClass, call);
    }

    private <R> HttpResponse<R> executeAndResponse(Class<R> responseClass, Call call) {
        Response response;
        HttpResponse<R> httpResponse = new HttpResponse<>();
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = Optional.of(response)
                        .map(Response::body).orElse(null);
                if (Objects.isNull(responseBody) || StringUtils.isBlank(responseBody.string())) {
                    return null;
                }
                R r = JsonUtils.strToObj(responseBody.string(), responseClass);
                httpResponse.setResponse(r);
                httpResponse.setSuccess(Boolean.TRUE);
                return httpResponse;
            }
            httpResponse.setMessage(response.message());
        } catch (IOException e) {
            httpResponse.setMessage(e.getMessage());
        }
        httpResponse.setSuccess(Boolean.FALSE);
        return httpResponse;
    }
}
