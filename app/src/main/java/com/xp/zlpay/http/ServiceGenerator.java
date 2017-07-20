package com.xp.zlpay.http;


import com.google.gson.Gson;
import com.xp.zlpay.dao.BaseModel;
import com.xp.zlpay.enums.RetcodeEnum;
import com.xp.zlpay.util.LogUtil;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.xp.zlpay.constant.UrlConsts.API_BASE_URL;

/**
 * Created by YC on 2017/07/11.
 */

public class ServiceGenerator {

    private static  final  String TAG = ServiceGenerator.class.getSimpleName();

    //log等级  分别NONE，BASIC，HEADERS，BODY
    private static final  HttpLoggingInterceptor.Level LOG_LEVEL = HttpLoggingInterceptor.Level.BODY;

    //设置超时时间
    private static final int DEFAULT_TIMEOUT = 5;


    private static  ServiceGenerator mInstance;

    private ServiceGenerator(){}

    private  BaseInterceptor mBaseInterceptor;

    private  Retrofit.Builder builder;

    //增加日志
    private static    HttpLoggingInterceptor logging ;

    private static OkHttpClient.Builder httpClient ;

    public static  synchronized  ServiceGenerator getInstance(){
        if(null == mInstance){
            mInstance = new ServiceGenerator();
        }
        return  mInstance;
    }

    /**
     * 初始化
     */
    private  void init(){
        if(null == httpClient){
            httpClient = new OkHttpClient.Builder();
        }
        if(null ==builder){
            builder = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
        }
        if(null == logging){
            logging = new HttpLoggingInterceptor();
        }
        //设置连接超时
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);
    }

    public  <S> S createService(Class<S> serviceClass) {
        init();
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    /**
     * 需要添加头部信息
     * @param serviceClass 接口类
     * @param headers 头
     * @param <S>
     * @return
     */
    public  <S> S createService(Class<S> serviceClass,Map<String,String> headers) {
        init();
        mBaseInterceptor = BaseInterceptor.getBaseInterceptor();
        mBaseInterceptor.setHeaders(headers);
        httpClient.addInterceptor(mBaseInterceptor);
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

    /**
     *
     * @param callBack
     * @param callBackData
     * @param cmd 区分那个连接
     * @param modelClass 模型
     */
    public  void getCallBackData(Call<ResponseBody> callBack, final CallBackData callBackData, final int cmd, final Class modelClass){
        LogUtil.e(TAG+"--callBack--method--",callBack.request().method());
        callBack.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    String message = null;
                    try {
                        message = response.body().string();
                        LogUtil.e(TAG+"--result--",message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Gson gson = new Gson();
                    BaseModel baseModel = (BaseModel) gson.fromJson(message,modelClass);
                    if(RetcodeEnum.SUCC.getValue() == baseModel.getShowapi_res_code()){
                        callBackData.netSuccess(baseModel,cmd);
                    }else{
                        callBackData.responeLogicError(baseModel.getShowapi_res_error());
                    }

                }else{
                    try {
                        LogUtil.e(TAG+"--error--",response.errorBody().string());
                        callBackData.netError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                LogUtil.e(TAG+"--onFailure--",call.request().method());
                callBackData.netFailure();
            }
        });
    }
}
