package com.example.anew.msbuddy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by New on 08/04/2018.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public ArrayList<String> myvalue1,myValues;

    public ArrayList<article_uni> uni_detail;

    public RecyclerViewAdapter(ArrayList<String> unilist, ArrayList<String> myValues,ArrayList<article_uni> uni_detail){
        this.myvalue1=unilist;
        this.myValues= myValues;
        this.uni_detail=uni_detail;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.uni_layout, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.myTextView.setText(myvalue1.get(position));
        holder.myTextView1.setText(myValues.get(position));
        holder.rank.setText(uni_detail.get(position).getRank());
        holder.location.setText(uni_detail.get(position).getLocation());
        holder.detail.setText(uni_detail.get(position).getDetail());
        holder.fees.setText(uni_detail.get(position).getFees());
        holder.website.setText(uni_detail.get(position).getWeb());
    }


    @Override
    public int getItemCount() {
        return myValues.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView myTextView,myTextView1,rank,fees,location,detail,website;
        public MyViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView)itemView.findViewById(R.id.uninamewhole);
            myTextView1= (TextView)itemView.findViewById(R.id.aord2);
            rank = (TextView)itemView.findViewById(R.id.rankwhole);
            location =(TextView)itemView.findViewById(R.id.locationwhole);
            fees=(TextView)itemView.findViewById(R.id.tuitionfeeswhole);
            detail = (TextView)itemView.findViewById(R.id.newdescription);
            website = (TextView)itemView.findViewById(R.id.websitewholefinal);

        }
    }
}