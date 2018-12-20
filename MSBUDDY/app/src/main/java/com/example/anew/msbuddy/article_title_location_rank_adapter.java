package com.example.anew.msbuddy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by New on 27/01/2018.
 */
public class article_title_location_rank_adapter extends RecyclerView.Adapter<article_title_location_rank_adapter.MyViewHolder> {

    private List<article_uni> articleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Name,Location,Rank,Detail,Fees,Web;

        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.uninamewhole);
            Rank =(TextView) view.findViewById (R.id.rankwhole);
            Detail =(TextView) view.findViewById(R.id.detailwhole);
            Fees =(TextView) view.findViewById(R.id.tuitionfeeswhole);
            Web =(TextView) view.findViewById(R.id.websitefinal);
            Location = (TextView)view.findViewById(R.id.locationwhole);


        }
    }


    public article_title_location_rank_adapter(List<article_uni> articleList) {
        this.articleList = articleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_uni_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        article_uni ar = articleList.get(position);
        holder.Name.setText(ar.getName());
        holder.Location.setText(ar.getLocation());
        holder.Web.setText(ar.getWeb());
        holder.Fees.setText(ar.getFees());
        holder.Rank.setText(ar.getRank());
       holder.Detail.setText(ar.getDetail());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }



}
