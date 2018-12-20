package com.example.anew.msbuddy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

import static com.example.anew.msbuddy.R.layout.uni_layout;

public class final_University_Result extends AppCompatActivity {

    List<article> articleList = new ArrayList<>();
    article_title_adapter articletitleAdapter;
    RecyclerView recyclerView;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final__university__result);
        ArrayList<String> myList = (ArrayList<String>)getIntent().getSerializableExtra("myList");
        ArrayList<String> unilist = (ArrayList<String>)getIntent().getSerializableExtra("uniList");
        //ls = findViewById(R.id.lv);

        final GlobalClass objglobal= (GlobalClass)getApplicationContext();

        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //View v = LayoutInflater.from(this).inflate(R.layout.uni_layout, null);


        CardView obj = (CardView)layoutInflater.inflate(uni_layout,null);
        //CardView obj = (CardView)findViewById(R.id.uniwholecard);

        final TextView swap = (TextView) findViewById(R.id.Coool);

        if ((objglobal.getCount())>1)
        {
            Log.d("Counttttttttttttttttttt", String.valueOf(objglobal.getCount()));
            final TourGuide mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.CLICK)
                    .setPointer(new Pointer())
                    .setToolTip(new ToolTip().setTitle("Click Here").setDescription("Swipe Right"))
                    .setOverlay(new Overlay())
                    .playOn(swap);
            swap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    swap.setVisibility(View.INVISIBLE);
                    mTourGuideHandler.cleanUp();
                }
            });
         }

        Log.d("FinalNamees", String.valueOf(unilist));
        // final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        //ls.setAdapter(arrayAdapter);

        ArrayList<article_uni> uni_detail = (ArrayList<article_uni>) getIntent().getSerializableExtra("uni_detail");
        Collections.reverse(uni_detail);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(unilist,myList,uni_detail);


        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(unilist,myList);
        //  RecyclerViewAdapter adapter1 =  new RecyclerViewAdapter(myList);
        RecyclerView myView =  (RecyclerView)findViewById(R.id.recyclerview);
        myView.setHasFixedSize(true);
        myView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        myView.setLayoutManager(llm);


        if (objglobal.getCount()>1)
        {
            TourGuide mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.CLICK)
                    .setPointer(new Pointer())
                    .setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin..."))
                    .setOverlay(new Overlay());
        }

        /*recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            articletitleAdapter = new article_title_adapter(articleList);

            RecyclerView.LayoutManager aLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(aLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

            recyclerView.setAdapter(articletitleAdapter);
            ArrayList<String> myList = (ArrayList<String>)getIntent().getSerializableExtra("myList");
            ArrayList<String> unilist = (ArrayList<String>)getIntent().getSerializableExtra("uniList");

            //final String moni = getIntent().getStringExtra("moni");

            //Toast.makeText(getApplicationContext(), moni, Toast.LENGTH_SHORT).show();

            for(int i = 0 ; i<myList.size();i++)
            {
                article arti1 = new article(unilist.get(i));
                articleList.add(arti1);
                article arti = new article(myList.get(i));
                articleList.add(arti);
            }

           // listOfUni.add(str);

            //count++;
            // Toast.makeText(getApplicationContext(), listOfUni.get(0), Toast.LENGTH_SHORT).show();

            articletitleAdapter.notifyDataSetChanged();
        }
*/


    }
}
