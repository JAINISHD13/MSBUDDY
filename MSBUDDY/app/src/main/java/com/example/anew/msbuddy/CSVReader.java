package com.example.anew.msbuddy;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by New on 07/02/2018.
 */
public class CSVReader {

    Context context;
    String fileName;
    List<String> rows = new ArrayList<>();

    public CSVReader(Context context) {
        this.context = context;
        this.fileName = fileName;

    }

    public List<String> readCSV() throws IOException {

       // InputStream is = context.getAssets().open(fileName);
        InputStream is = context.getResources().openRawResource(R.raw.university);

       // Toast.makeText(context,fileName,Toast.LENGTH_SHORT).show();

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);
        String line;
        String csvSplitBy = ",";

        br.readLine();

        while ((line = br.readLine()) != null) {
           // String[] row = line.split(csvSplitBy);
            rows.add(line);
        }
        return rows;
    }

}
