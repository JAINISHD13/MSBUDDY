package com.example.anew.msbuddy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EducationActivity extends Fragment  {
    @Nullable
    // @Override
    private RadioButton rbt;
    private String radioText;
    private RadioGroup radioGroup;
    private TextView backbtn,proceed;
    View myview;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_education, container ,false);
        radioGroup=(RadioGroup) myview.findViewById(R.id.radioGroupEd);

        proceed= (TextView)myview.findViewById(R.id.txt2);
        backbtn = (TextView)myview.findViewById(R.id.txtback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*int id=group.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton) findViewById(id);
                OR*/
                RadioButton rb= (RadioButton) myview.findViewById(checkedId);
                radioText=rb.getText().toString();
                Log.d("selected text:",radioText);
                final GlobalClass objglobal= (GlobalClass)getActivity().getApplicationContext();
                objglobal.setCuurent_Ed_level(radioText);



            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity().getApplicationContext(), "Select option", Toast.LENGTH_SHORT).show();
                }
                else {
                    android.app.FragmentManager fragmentmanager = getFragmentManager();

                    fragmentmanager.beginTransaction()
                            .replace(R.id.content_frame
                                    , new ExamActivity()).addToBackStack("B")
                            .commit();
                }
            }
        });




        return myview;
    }





}

