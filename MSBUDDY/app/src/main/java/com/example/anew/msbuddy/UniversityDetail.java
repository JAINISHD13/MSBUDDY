package com.example.anew.msbuddy;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UniversityDetail extends Fragment {
    @Nullable
    // @Override

            View myview;
    private EditText ed1,ed2,ed3,ed4;
    private TextView proceed ,backbtn;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_university_detail, container ,false);


        proceed=(TextView)myview. findViewById(R.id.txt2);
        backbtn = (TextView)myview.findViewById(R.id.txtback);
        ed1 = (EditText)myview.findViewById(R.id.edtxt1);
        ed2 = (EditText)myview.findViewById(R.id.edt2);
        ed3 = (EditText)myview.findViewById(R.id.edt3);
        ed4 = (EditText)myview.findViewById(R.id.edt4);



        String a="30.3";
        Float f= Float.valueOf(a);
        String b= String.valueOf(f);
        Log.d("foat f", String.valueOf(f));
        Log.d("ed1",ed1.getText().toString());


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });
        final GlobalClass objglobal= (GlobalClass)getActivity(). getApplicationContext();
        /*Log.d("TOEFL reading", String.valueOf(objglobal.getReading()));
        Log.d("TOEFL listening", String.valueOf(objglobal.getListening()));
        Log.d("TOEFL Writing", String.valueOf(objglobal.getWriting()));
        Log.d("TOEFL speaking", String.valueOf(objglobal.getSpeaking()));*/
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float cgpa , backlog , workexp , researchpaper;
                if(ed1.getText().toString().equals("") || ed2.getText().toString().equals("") || ed3.getText().toString().equals("") || ed4.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity().getApplicationContext(),"Must fill all the data" ,Toast.LENGTH_SHORT ).show();

                }
                else {
                    cgpa = Float.parseFloat(ed1.getText().toString().trim());
                    backlog = Integer.parseInt(ed2.getText().toString());
                    workexp =Float.parseFloat(ed3.getText().toString());
                    researchpaper = Float.parseFloat(ed4.getText().toString());
                    if(cgpa>10 || cgpa<0 || backlog<0 ||backlog>45 || workexp<0 || researchpaper<0 )
                    {
                        Toast.makeText(getActivity().getApplicationContext(),"Enter valid value" ,Toast.LENGTH_SHORT ).show();
                    }
                    else {



                        objglobal.setCgpa(Float.parseFloat(ed1.getText().toString().trim()));

                        objglobal.setBacklogs(Integer.parseInt(ed2.getText().toString()));

                        objglobal.setWorkexp(Float.parseFloat(ed3.getText().toString()));

                        objglobal.setResearch_paper(Float.parseFloat(ed4.getText().toString()));



                        android.app.FragmentManager fragmentmanager = getFragmentManager();

                        fragmentmanager.beginTransaction()
                                .replace(R.id.content_frame
                                        ,new User_Details()).addToBackStack(null)
                                .commit();
                    }

                }






            }
        });
        return myview;
    }
}
