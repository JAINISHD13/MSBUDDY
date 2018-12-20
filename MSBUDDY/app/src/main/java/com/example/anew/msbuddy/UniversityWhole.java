package com.example.anew.msbuddy;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniversityWhole  extends Fragment {
    @Nullable
    // @Override
            View myview;
    RecyclerView recyclerView;
    List<article_uni> articleList = new ArrayList<>();
    article_title_location_rank_adapter articletitleAdapter;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_university_whole, container ,false);

        final GlobalClass objglobal = (GlobalClass)getActivity(). getApplicationContext();



        recyclerView=(RecyclerView) myview.findViewById(R.id.recycler_view);
        // prepareArticleData();
        if(recyclerView!=null) {
            articletitleAdapter = new article_title_location_rank_adapter(articleList);
            RecyclerView.LayoutManager aLayoutManager = new LinearLayoutManager(this.getActivity());
            recyclerView.setLayoutManager(aLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.HORIZONTAL));
            recyclerView.setAdapter(articletitleAdapter);
            prepareArticleData();
        }
        else
        {
           // Toast.makeText(this.getActivity(),"monika",Toast.LENGTH_SHORT).show();
        }


        return myview;
    }


    private void prepareArticleData() {

        List<article_uni> rows = new ArrayList<>();

        CSVReader_Details csvReader = new CSVReader_Details(getActivity().getApplicationContext());

        try
        {
            rows = csvReader.readCSV();
        } catch (IOException e) {
            //Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
        }

        for(article_uni i  :  rows)
        {
            article_uni arti = new article_uni();

            arti.setWeb(i.getWeb());
            arti.setDetail(i.getDetail());
            arti.setFees(i.getFees());
            arti.setLocation(i.getLocation());
            arti.setRank(i.getRank());
            arti.setName(i.getName());
            articleList.add(arti);

        }
        articletitleAdapter.notifyDataSetChanged();

    }
}
