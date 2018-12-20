package com.example.anew.msbuddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluated_Result extends AppCompatActivity {

    List<article> articleList = new ArrayList<>();
    article_title_adapter articletitleAdapter;
    RecyclerView recyclerView;
    final ArrayList<String> listOfUni = new ArrayList<String>();
    int i, count =0,flag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluated__result);

        final GlobalClass objglobal= (GlobalClass)getApplicationContext();

        // ActionBar ab = getActionBar();
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        //final String server_url = "C:\\xampp\\htdocs\\WebService.php";
        final String server_url = "http://192.168.43.110/WebService.php";
        final String gre_V = String.valueOf(objglobal.getVerbal());
        final String gre_Q = String.valueOf(objglobal.getQuant());
        String gre_A = String.valueOf(objglobal.getAwa());
        final String Toefl_R ,Toefl_W , Toefl_L ,Toefl_S;
        if(objglobal.getTofelorielts()==0)
        {
             Toefl_R = String.valueOf(objglobal.getReading());
             Toefl_W = String.valueOf(objglobal.getWriting());
             Toefl_L = String.valueOf(objglobal.getListening());
             Toefl_S = String.valueOf(objglobal.getSpeaking());
        }
        else
        {
            IeltsToToeflConverter obj = new IeltsToToeflConverter();

            Toefl_R =String.valueOf(obj.convert(objglobal.getReading()));
            Toefl_W = String.valueOf(obj.convert(objglobal.getWriting()));
            Toefl_L = String.valueOf(obj.convert(objglobal.getListening()));
            Toefl_S = String.valueOf(obj.convert(objglobal.getSpeaking()));
            //Toast.makeText(this,Toefl_L+" "+Toefl_R+" "+Toefl_S+" "+Toefl_W,Toast.LENGTH_SHORT).show();
        }

        final String UG =String.valueOf((objglobal.getCgpa()*10));
        final String WE = String.valueOf(objglobal.getWorkexp());
        final String RP = String.valueOf(objglobal.getResearch_paper());
        recyclerView = (RecyclerView)findViewById(R.id.rv);

       // Toast.makeText(this,UG,Toast.LENGTH_SHORT).show();

        try
        {
            int Quant = objglobal.getQuant();
            int Verbal = objglobal.getVerbal();
            int total_gre = Quant + Verbal;
            float total_toefl = objglobal.getListening() + objglobal.getReading()+ objglobal.getSpeaking() + objglobal.getWriting();
            float grade = objglobal.getCgpa();
            float worl = objglobal.getWorkexp();
            float paper = objglobal.getResearch_paper();
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Could not parse " + nfe);
        }


       // Button result = (Button) findViewById(R.id.evaluate);
        Button adduniversity = (Button) findViewById(R.id.addUniversity);
        Button btn2 =(Button) findViewById(R.id.evaluate);


        if (btn2 != null) {
            btn2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    final ProgressDialog pg = new ProgressDialog(Evaluated_Result.this);
                    pg.setMessage("Wait for Result");
                    pg.show();

                    RequestQueue requestQueue = Volley.newRequestQueue(Evaluated_Result.this);

                    final ArrayList<String> myList = new ArrayList<String>();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                                    Log.d("My msg", response);
                                    int num=response.length();
                                    switch (num)
                                    {
                                        case 1:
                                        {
                                            char Decision1 = response.charAt(0);
                                            String decision1;
                                            if (Decision1=='A')
                                                decision1 = "Accept";
                                            else if (Decision1=='R')
                                                decision1 = "Reject";
                                            else
                                                decision1 = "Error";

                                            myList.add(decision1);
                                            break;
                                        }
                                        case 2:
                                        {
                                            char Decision1 = response.charAt(0);
                                            char Decision2 = response.charAt(1);
                                            String decision1;
                                            String decision2;
                                            if (Decision1=='A')
                                                decision1 = "Accept";
                                            else if (Decision1=='R')
                                                decision1 = "Reject";
                                            else
                                                decision1 = "Error";

                                            myList.add(decision1);

                                            if (Decision2=='A')
                                                decision2 = "Accept";
                                            else if(Decision2=='R')
                                                decision2 = "Reject";
                                            else
                                                decision2 = "Error";

                                            myList.add(decision2);
                                            break;
                                        }
                                        case 3:
                                        {
                                            char Decision1 = response.charAt(0);
                                            char Decision2 = response.charAt(1);
                                            char Decision3 = response.charAt(2);
                                            String decision1;
                                            String decision2;
                                            String decision3;
                                            if (Decision1=='A')
                                                decision1 = "Accept";
                                            else if (Decision1=='R')
                                                decision1 = "Reject";
                                            else
                                                decision1 = "Error";

                                            myList.add(decision1);

                                            if (Decision2=='A')
                                                decision2 = "Accept";
                                            else if(Decision2=='R')
                                                decision2 = "Reject";
                                            else
                                                decision2 = "Error";

                                            myList.add(decision2);

                                            if (Decision3=='A')
                                                decision3 = "Accept";
                                            else
                                                decision3 = "Reject";

                                            myList.add(decision3);
                                            break;
                                        }
                                        case 4:
                                        {
                                            char Decision1 = response.charAt(0);
                                            char Decision2 = response.charAt(1);
                                            char Decision3 = response.charAt(2);
                                            char Decision4 = response.charAt(3);
                                            String decision1;
                                            String decision2;
                                            String decision3;
                                            String decision4;
                                            if (Decision1=='A')
                                                decision1 = "Accept";
                                            else if (Decision1=='R')
                                                decision1 = "Reject";
                                            else
                                                decision1 = "Error";

                                            myList.add(decision1);

                                            if (Decision2=='A')
                                                decision2 = "Accept";
                                            else if(Decision2=='R')
                                                decision2 = "Reject";
                                            else
                                                decision2 = "Error";

                                            myList.add(decision2);

                                            if (Decision3=='A')
                                                decision3 = "Accept";
                                            else
                                                decision3 = "Reject";

                                            myList.add(decision3);

                                            if (Decision4=='A')
                                                decision4 = "Accept";
                                            else
                                                decision4 = "Reject";
                                            myList.add(decision4);
                                            break;
                                        }
                                        case 5:
                                        {
                                            char Decision1 = response.charAt(0);
                                            char Decision2 = response.charAt(1);
                                            char Decision3 = response.charAt(2);
                                            char Decision4 = response.charAt(3);
                                            char Decision5 = response.charAt(4);
                                            String decision1;
                                            String decision2;
                                            String decision3;
                                            String decision4;
                                            String decision5;

                                            if (Decision1=='A')
                                                decision1 = "Accept";
                                            else if (Decision1=='R')
                                                decision1 = "Reject";
                                            else
                                                decision1 = "Error";

                                            myList.add(decision1);

                                            if (Decision2=='A')
                                                decision2 = "Accept";
                                            else if(Decision2=='R')
                                                decision2 = "Reject";
                                            else
                                                decision2 = "Error";

                                            myList.add(decision2);

                                            if (Decision3=='A')
                                                decision3 = "Accept";
                                            else
                                                decision3 = "Reject";

                                            myList.add(decision3);

                                            if (Decision4=='A')
                                                decision4 = "Accept";
                                            else
                                                decision4 = "Reject";

                                            myList.add(decision4);

                                            if (Decision5=='A')
                                                decision5 = "Accept";
                                            else
                                                decision5 = "Reject";
                                            myList.add(decision5);
                                            break;
                                        }
                                    }

                                    pg.dismiss();
                                    objglobal.setCount(count);

                                    ArrayAdapter<String> adapter_new;
                                    //List<article_uni> list_new = new ArrayList<>();

                                    List<article_uni> rows_new = new ArrayList<>();

                                    CSVReader_New csvReader_details = new CSVReader_New(getApplicationContext(),listOfUni);

                                    try {
                                        rows_new = csvReader_details.readCSV();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }


                                    Intent myIntent = new Intent(getApplicationContext(),final_University_Result.class);
                                    myIntent.putExtra("myList", myList);
                                    myIntent.putExtra("uniList", listOfUni);
                                    myIntent.putExtra("uni_detail", (Serializable) rows_new);

                                    startActivity(myIntent);

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    error.printStackTrace();
                                }
                            })

                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError{
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("gre_V", gre_V);
                            params.put("gre_Q", gre_Q);
                            params.put("toefl_S", Toefl_S);
                            params.put("toefl_L", Toefl_L);
                            params.put("toefl_W", Toefl_W);
                            params.put("toefl_R", Toefl_R);
                            params.put("UG", UG);
                            params.put("WE", WE);
                            params.put("RP", RP);
                            for(int i=0;i<listOfUni.size();i++)
                            {

                                params.put("University"+(i+1), listOfUni.get(i));

                            }
                        //    params.put("University1", listOfUni.get(0));
                         //   params.put("University2", listOfUni.get(1));
                           // params.put("University3", listOfUni.get(2));
                           // params.put("University4", listOfUni.get(3));
                           // params.put("University5", listOfUni.get(4));
                            Integer n = listOfUni.size();
                            params.put("Number", n.toString() );
                            return params;
                        }
                    };

                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(500000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    requestQueue.add(stringRequest);
                    //MySingleton.getInstance(Evaluated_Result.this).addToRequestQueue(stringRequest);
                    //MySingleton.getInstance(Evaluated_Result.this).addToRequestQueue(jsonObjectRequest);

                }
            });
        }

        //          Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.search);
        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<String>();

        List<String> rows = new ArrayList<>();
        CSVReader csvReader = new CSVReader(getApplicationContext());

        try
        {
            rows = csvReader.readCSV();
           // Toast.makeText(this, "moni", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        for (int i = 0; i < rows.size(); i++) {
            list.add(rows.get(i));
        }

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setAdapter(adapter);

        }



        if (adduniversity != null ) {
            adduniversity.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    if( autoCompleteTextView!=null) {
                        flag=1;
                        String str = autoCompleteTextView.getText().toString();
                        for(i=0; i<count;i++)
                        {
                            if(listOfUni.get(i).compareTo(str)==0)
                            {
                                flag=0;
                            }

                        }
                        if (recyclerView != null && count<5 && flag==1 && !str.equals("")) {
                            articletitleAdapter = new article_title_adapter(articleList);

                            RecyclerView.LayoutManager aLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(aLayoutManager);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                            recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));

                            recyclerView.setAdapter(articletitleAdapter);
                            article arti = new article(str);
                            articleList.add(arti);
                            listOfUni.add(str);
                            autoCompleteTextView.setText("");

                            count++;
                           // Toast.makeText(getApplicationContext(), listOfUni.get(0), Toast.LENGTH_SHORT).show();

                            articletitleAdapter.notifyDataSetChanged();
                        }
                        else if(listOfUni.size()>=5) {
                            Toast.makeText(getApplicationContext(), "No more than 5 university", Toast.LENGTH_SHORT).show();
                        }
                        else if(flag==0)
                        {
                            Toast.makeText(getApplicationContext(), "university already added in list", Toast.LENGTH_SHORT).show();

                        }
                        else if(str.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "please select any university", Toast.LENGTH_SHORT).show();

                        }
                    }
                    //
                     }


                    });


        }



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);

    }
}