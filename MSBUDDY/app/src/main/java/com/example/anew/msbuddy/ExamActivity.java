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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExamActivity extends Fragment {
    @Nullable
    // @Override

    View myview;
    TextView backbtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_exam, container ,false);
        final GlobalClass objglobal= (GlobalClass)getActivity().getApplicationContext();

        Button btn1 = (Button)myview.findViewById(R.id.btn1);
        Button btn2 = (Button)myview.findViewById(R.id.btn2);
        backbtn = (TextView)myview.findViewById(R.id.txtback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            { android.app.FragmentManager fragmentmanager = getFragmentManager();

                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new GREMarks()).addToBackStack("C")
                        .commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentManager fragmentmanager = getFragmentManager();

                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new EnglishProficiency()).addToBackStack(null)
                        .commit();

            }
        });

        return myview;
    }
}