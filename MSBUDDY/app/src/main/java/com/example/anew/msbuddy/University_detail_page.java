package com.example.anew.msbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class University_detail_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_detail_page);

        int n = getIntent().getIntExtra("article_position",-1);

        List<article_uni> rows = new ArrayList<>();

        TextView Name,Location,Rank,Detail,Fees,Web;

        Name = (TextView)findViewById(R.id.uninamewhole);
        Rank =(TextView)findViewById (R.id.rankwhole);
        Detail =(TextView)findViewById(R.id.detailwhole);
        Fees =(TextView)findViewById(R.id.tuitionfeeswhole);
        Web =(TextView)findViewById(R.id.websitefinal);
        Location = (TextView)findViewById(R.id.locationwhole);

       // List<article> rows1 = new ArrayList<>();

        CSVReader_Details csvReader = new CSVReader_Details(getApplicationContext());

        try
        {
            rows = csvReader.readCSV();

        } catch (IOException e) {
            //Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
        }

        Name.setText(rows.get(n).getName());
        Location.setText(rows.get(n).getLocation());
        Rank.setText(rows.get(n).getRank());
        Detail.setText(rows.get(n).getDetail());
        Fees.setText(rows.get(n).getFees());
        Web.setText(rows.get(n).getWeb());

    }
}
