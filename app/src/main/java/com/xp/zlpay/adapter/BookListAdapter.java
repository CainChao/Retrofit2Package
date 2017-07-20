package com.xp.zlpay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xp.zlpay.R;
import com.xp.zlpay.dao.BookListInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author YC
 * 2017/7/12 0012.
 */

public class BookListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContex;

    private List<BookListInfo> listData = new ArrayList<>();

    public BookListAdapter(Context context){
        this.mContex = context;
    }

    public void setData(List<BookListInfo> data){
        listData.clear();
        if(null != data){
            listData.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookListViewHolder(LayoutInflater.from(mContex).inflate(R.layout.adapter_book_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BookListInfo bookListInfo = listData.get(position);
        BookListViewHolder viewHolder  = (BookListViewHolder) holder;
        viewHolder.tv_author.setText(bookListInfo.getAuthor());
        viewHolder.tv_name.setText(bookListInfo.getName());
        viewHolder.tv_summary.setText(bookListInfo.getSummary());
        Glide.with(mContex).load(bookListInfo.getImg()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static  class BookListViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img)
        ImageView img;

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_author)
        TextView tv_author;

        @BindView(R.id.tv_summary)
        TextView tv_summary;

        public BookListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
