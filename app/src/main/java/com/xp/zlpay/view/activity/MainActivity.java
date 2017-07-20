package com.xp.zlpay.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xp.zlpay.adapter.BookListAdapter;
import com.xp.zlpay.dao.BaseModel;
import com.xp.zlpay.R;
import com.xp.zlpay.constant.Congfig;
import com.xp.zlpay.dao.BookListModel;
import com.xp.zlpay.enums.UrlListEnum;
import com.xp.zlpay.http.CallBackData;
import com.xp.zlpay.http.CallbackService;
import com.xp.zlpay.http.ServiceGenerator;
import com.xp.zlpay.presenter.BookListPre;
import com.xp.zlpay.presenter.impl.BookListPreImpl;
import com.xp.zlpay.view.BookListView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity  implements BookListView{

    private BookListAdapter adapter;

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private BookListPre mBookListPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBookListPre = new BookListPreImpl(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_list.setLayoutManager(layoutManager);

        adapter = new BookListAdapter(this);
        rv_list.setAdapter(adapter);

        mBookListPre.sendRequest();

    }

    @Override
    public void netSuccess(BaseModel model, int cmd) {
        if(cmd == UrlListEnum.BOOKSLIST.getValue()){
            BookListModel bookListModel = (BookListModel) model;
            adapter.setData(bookListModel.getShowapi_res_body().getBookList());
        }
    }

    @Override
    public void netFailure() {

    }

    @Override
    public void netError(String error) {

    }

    @Override
    public void responeLogicError(String logicError) {
    }
}
