package com.example.anew.msbuddy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by New on 23/09/2017.
 */
public class home_fragment extends Fragment implements View.OnClickListener {
   // @Nullable
  //  @Override
    View myview;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       myview = inflater.inflate(R.layout.home, container ,false);
        Button btn1 = (Button) myview.findViewById(R.id.button1);
        Button btn2 = (Button)myview.findViewById(R.id.button2);
        Button btn3 = (Button)myview.findViewById(R.id.button3);
        Button btn4 = (Button)myview.findViewById(R.id.button4);
        Button btn5 = (Button)myview.findViewById(R.id.button5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        return myview;


    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentmanager = getFragmentManager();
        switch (v.getId()) {

            case R.id.button1:
                // do your code
                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new profileevaluator_fragment())
                        .commit();
                getActivity().setTitle("Profile Evaluater");
                break;

            case R.id.button2:
                // do your code
                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new about_GRE_fragment())
                        .commit();
                getActivity().setTitle("About GRE");
                break;

            case R.id.button3:
                // do your code
                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new about_TOEFL_fragment())
                        .commit();
                getActivity().setTitle("About TOEFL");
                break;
            case R.id.button4:
                // do your code
                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new about_IELTS_fragment() )
                        .commit();
                getActivity().setTitle("About IELTS");
                break;
            case R.id.button5:
                // do your code
                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new universityranking_fragment())
                        .commit();
                getActivity().setTitle("University Ranking");

                break;

            default:
                break;
        }
    }
}
