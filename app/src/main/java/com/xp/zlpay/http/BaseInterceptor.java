package com.xp.zlpay.http;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author YC
 * 构建基础拦截器 用来设置基础header
 * 2017/6/15 0015.
 */

public class BaseInterceptor implements Interceptor {
    private Map<String, String> headers;

    private BaseInterceptor(){}

    private static  BaseInterceptor mBaseInterceptor;

    public static  synchronized  BaseInterceptor getBaseInterceptor(){
        if(null == mBaseInterceptor){
            mBaseInterceptor = new BaseInterceptor();
        }
        return  mBaseInterceptor;
    }

    @Override
    public Response intercept(Chain chain) throws    IOException {

        Request.Builder builder = chain.request()
                .newBuilder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey,   headers.get(headerKey)).build();
            }
        }
        return chain.proceed(builder.build());
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
