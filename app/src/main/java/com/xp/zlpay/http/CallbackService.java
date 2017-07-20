package com.xp.zlpay.http;

import com.xp.zlpay.enums.UrlListEnum;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public interface CallbackService {

    /**
     * Post请求
     * @param path
     * @param params
     * @return
     */
    @POST("{path}")
    Call<ResponseBody> requestPost(@Path("path")String path,@QueryMap Map<String,String> params);


    /**
     * Get请求
     * @param path
     * @param params
     * @return
     */
    @GET("{path}")
    Call<ResponseBody> requestGET(@Path("path")String path,@QueryMap Map<String,String> params);
}
