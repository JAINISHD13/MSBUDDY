package com.example.anew.msbuddy;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by New on 23/09/2017.
 */
public class universityranking_fragment extends Fragment {
    @Nullable
   // @Override

    View myview;
    RecyclerView recyclerView;
    List<article> articleList = new ArrayList<>();
    article_title_adapter articletitleAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       myview = inflater.inflate(R.layout.universityranking, container ,false);

        recyclerView=(RecyclerView) myview.findViewById(R.id.recycler_view);
        // prepareArticleData();
        if(recyclerView!=null) {
            articletitleAdapter = new article_title_adapter(articleList);
            RecyclerView.LayoutManager aLayoutManager = new LinearLayoutManager(this.getActivity());
            recyclerView.setLayoutManager(aLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), LinearLayoutManager.VERTICAL));

            recyclerView.setAdapter(articletitleAdapter);
            prepareArticleData();
            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this.getActivity(), recyclerView, new ClickListener() {

                public void onClick(View view, int position) {
                    article arti = articleList.get(position);
                    //  Toast.makeText(view.getContext(), arti.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                    Context context;
                    context=view.getContext();
                    Intent i = new Intent(context, University_detail_page.class);
                    i.putExtra("article_position" , position);
                    context.startActivity(i);

                }

                public void onLongClick(View view, int position) {

                }
            }));

        }
        else
        {
            Toast.makeText(this.getActivity(),"monika",Toast.LENGTH_SHORT).show();
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
            article arti = new article();

            arti.setTitle(i.getName());
            articleList.add(arti);

        }
        articletitleAdapter.notifyDataSetChanged();

    }

}
