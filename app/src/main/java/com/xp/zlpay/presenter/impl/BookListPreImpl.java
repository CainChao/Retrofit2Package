package com.xp.zlpay.presenter.impl;

import com.xp.zlpay.constant.Congfig;
import com.xp.zlpay.dao.BaseModel;
import com.xp.zlpay.dao.BookListModel;
import com.xp.zlpay.enums.UrlListEnum;
import com.xp.zlpay.http.CallBackData;
import com.xp.zlpay.http.CallbackService;
import com.xp.zlpay.http.ServiceGenerator;
import com.xp.zlpay.presenter.BookListPre;
import com.xp.zlpay.view.BookListView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public class BookListPreImpl implements BookListPre,CallBackData {
    private BookListView mBookListView;


    private ServiceGenerator mServiceGenerator;

    private CallbackService mService;

    public BookListPreImpl(BookListView bookListView){
        this.mBookListView = bookListView;
    }

    @Override
    public void sendRequest() {
        mServiceGenerator = ServiceGenerator.getInstance();
        mService = mServiceGenerator.createService(CallbackService.class);
        Map<String,String> param = new HashMap<>();
        //请求页数
        param.put("page","1");
        //每页返回的条数
        param.put("limit","20");
        //排序方式 id：最新时间，count：访问最多，默认是id，按最新时间。
        param.put("type","count");
        // 图书分类的ID 默认为 null ，也就是全部
        // param.put("id",null);
        param.put("showapi_appid", Congfig.SHOWAPI_APPID);
        param.put("showapi_sign",Congfig.SHOWAPI_SIGN);
        Call<ResponseBody> callBack = mService.requestPost(UrlListEnum.BOOKSLIST.getKey(),param);
        mServiceGenerator.getCallBackData(callBack,this,UrlListEnum.BOOKSLIST.getValue(), BookListModel.class);
    }

    @Override
    public void netSuccess(BaseModel model, int cmd) {
        mBookListView.netSuccess(model,cmd);
    }

    @Override
    public void netFailure() {
        mBookListView.netFailure();
    }

    @Override
    public void netError(String error) {
        mBookListView.netError(error);
    }

    @Override
    public void responeLogicError(String logicError) {
        mBookListView.responeLogicError(logicError);
    }
}
