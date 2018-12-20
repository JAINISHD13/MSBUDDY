package com.example.anew.msbuddy;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

public class User_Details extends Fragment {
    @Nullable
    // @Override

    View myview;
    TextView current,cgpa,backs,quant,verbal,awa,reading,listening,writing,speaking,workexp,research,intake;
    Button startover;

    @SuppressLint("LongLogTag")


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_user__details, container ,false);
        final GlobalClass objglobal= (GlobalClass)getActivity(). getApplicationContext();
        Log.d("User_Details_Fall_spring:",objglobal.getApply_for_sem());
        Log.d("User_Details_Current:",objglobal.getCuurent_Ed_level());
        Log.d("User_Details_Quant:", String.valueOf(objglobal.getQuant()));
        Log.d("User_Details__Verbal:", String.valueOf(objglobal.getVerbal()));
        Log.d("User_Details_AWA:", String.valueOf(objglobal.getAwa()));
        Log.d("User_Details_Reading:", String.valueOf(objglobal.getReading()));
        Log.d("User_Details_Listening:", String.valueOf(objglobal.getListening()));
        Log.d("User_Details_Writing:", String.valueOf(objglobal.getWriting()));
        Log.d("User_Details_Speaking:", String.valueOf(objglobal.getSpeaking()));
        Log.d("User_Details_Cgpa", String.valueOf(objglobal.getCgpa()));
        Log.d("User_Details_backs:", String.valueOf(objglobal.getBacklogs()));
        Log.d("User_Details_Intern:", String.valueOf(objglobal.getWorkexp()));
        Log.d("User_Details_research:", String.valueOf(objglobal.getResearch_paper()));


        intake = (TextView)myview.findViewById(R.id.intake);
        current =(TextView)myview.findViewById(R.id.current);
        quant =(TextView)myview.findViewById(R.id.quant);
        verbal=(TextView)myview.findViewById(R.id.verbal);
        awa = (TextView)myview.findViewById(R.id.awa);
        reading=(TextView)myview.findViewById(R.id.reading);
        listening=(TextView)myview.findViewById(R.id.listening);
        writing=(TextView)myview.findViewById(R.id.writing);
        speaking=(TextView)myview.findViewById(R.id.speaking);
        workexp=(TextView)myview.findViewById(R.id.workexp);
        research=(TextView)myview.findViewById(R.id.research);
        cgpa=(TextView)myview.findViewById(R.id.cgpa);
        backs=(TextView)myview.findViewById(R.id.backlogs);


        intake.setText(String.valueOf(objglobal.getApply_for_sem()));
        current.setText(String.valueOf(objglobal.getCuurent_Ed_level()));
        quant.setText((String.valueOf(objglobal.getQuant())));
        verbal.setText(String.valueOf(objglobal.getVerbal()));
        awa.setText((String.valueOf(objglobal.getAwa())));
        reading.setText( String.valueOf(objglobal.getReading()));
        listening.setText( String.valueOf(objglobal.getListening()));
        writing.setText(String.valueOf(objglobal.getWriting()));
        speaking.setText(String.valueOf(objglobal.getSpeaking()));
        workexp.setText(String.valueOf(objglobal.getWorkexp()));
        research.setText(String.valueOf(objglobal.getResearch_paper()));
        cgpa.setText(String.valueOf(objglobal.getCgpa()));
        backs.setText(String.valueOf(objglobal.getBacklogs()));


        startover = (Button)myview.findViewById(R.id.startover);
        startover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getActivity().getApplicationContext(),Evaluated_Result.class);

                startActivity(myIntent);
               // android.app.FragmentManager fragmentmanager = getFragmentManager();

                //fragmentmanager.beginTransaction()
                  //      .replace(R.id.content_frame
                    //            ,new Universityselection())
                      //  .commit();
                
            }
        });



        return myview;
    }
}