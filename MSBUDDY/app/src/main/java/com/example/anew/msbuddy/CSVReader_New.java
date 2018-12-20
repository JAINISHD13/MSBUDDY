package com.example.anew.msbuddy;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10-05-2018.
 */

public class CSVReader_New {
    Context context;
    String fileName;
    ArrayList<String> listOfUni;
    List<article_uni> rows = new ArrayList<>();

    public CSVReader_New(Context context,ArrayList<String> listOfUni)
    {
        this.context = context;
        this.fileName = fileName;
        this.listOfUni=listOfUni;
    }

    public List<article_uni> readCSV() throws IOException {

        // InputStream is = context.getAssets().open(fileName);
        InputStream is = context.getResources().openRawResource(R.raw.final_uni);

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);

        String line;

        br.readLine();

        while ((line = br.readLine()) != null)
        {

            // String[] row = line.split(csvSplitBy);
            String[] tokens = line.split(",");
            article_uni obj = new article_uni();
            for (String temp : listOfUni) {
                //Log.d("jh,bjh,",temp);
                if (temp.equals(tokens[0])){
                    Log.d("compared",temp);

                    obj.setLocation(tokens[1]);
                    obj.setRank(tokens[2]);
                    obj.setDetail(tokens[3]);
                    obj.setFees(tokens[4]);
                    obj.setWeb(tokens[tokens.length-1]);
                    rows.add(obj);
                    Log.d("Location",obj.getLocation());
                }
            }
        }
        return rows;
    }
}
