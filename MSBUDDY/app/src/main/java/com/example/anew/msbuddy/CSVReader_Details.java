package com.example.anew.msbuddy;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by New on 08/04/2018.
 */
public class CSVReader_Details
{
    Context context;
    String fileName;
    List<article_uni> rows = new ArrayList<>();

    public CSVReader_Details(Context context) {
        this.context = context;
        this.fileName = fileName;

    }

    public List<article_uni> readCSV() throws IOException {

        // InputStream is = context.getAssets().open(fileName);
        InputStream is = context.getResources().openRawResource(R.raw.uni_list3);

        //   Toast.makeText(context,fileName,Toast.LENGTH_SHORT).show();

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);
        String line;
        String csvSplitBy = ",";

        br.readLine();

        while ((line = br.readLine()) != null) {
            // String[] row = line.split(csvSplitBy);
            String[] tokens = line.split(",");
            article_uni obj = new article_uni();
            obj.setName(tokens[0]);
            obj.setLocation(tokens[1]);
            obj.setRank(tokens[2]);
            obj.setDetail(tokens[3]);
            obj.setFees(tokens[4]);
            obj.setWeb(tokens[5]);

            rows.add(obj);
        }
        return rows;
    }
}
