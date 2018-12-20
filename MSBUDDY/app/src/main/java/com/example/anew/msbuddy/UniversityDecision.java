package com.example.anew.msbuddy;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class UniversityDecision extends Fragment {
    @Nullable
    // @Override

            View myview;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_university_decision, container ,false);


        return myview;
    }
}