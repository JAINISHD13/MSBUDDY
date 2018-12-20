package com.example.anew.msbuddy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by New on 29/09/2017.
 */
public class article_title_adapter extends RecyclerView.Adapter<article_title_adapter.MyViewHolder> {
    private List<article> articleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textView2_article_title);

        }
    }


    public article_title_adapter(List<article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        article ar = articleList.get(position);
        holder.title.setText(ar.getTitle());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


}
