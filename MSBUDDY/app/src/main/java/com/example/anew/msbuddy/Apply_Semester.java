package com.example.anew.msbuddy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Apply_Semester  extends android.app.Fragment {
    @Nullable
    // @Override
            View myview;
    private RadioButton rbtn;
    private TextView proceed;
    private RadioGroup radioGroup;
    private String radioText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_apply__semester, container ,false);
        proceed =(TextView)myview.findViewById(R.id.txt2);
        radioGroup=(RadioGroup)myview.findViewById(R.id.radioGroup);

       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {

               RadioButton rb=(RadioButton)myview.findViewById(checkedId);
               radioText=rb.getText().toString();
               Log.d("selected text:",radioText);
               final GlobalClass objglobal= (GlobalClass)getActivity().getApplicationContext();
               objglobal.setApply_for_sem(radioText);


           }
       });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity().getApplicationContext(), "Select option", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // one of the radio buttons is checked
                    android.app.FragmentManager fragmentmanager = getFragmentManager();

                    fragmentmanager.beginTransaction()
                            .replace(R.id.content_frame
                                    ,new EducationActivity()).addToBackStack("A")
                            .commit();
                }


            }
        });

        return myview;
    }
}
