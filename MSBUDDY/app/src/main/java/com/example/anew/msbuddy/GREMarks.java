package com.example.anew.msbuddy;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class GREMarks  extends Fragment {
    @Nullable
    // @Override

    private SeekBar sk1, sk2, sk3;
    private TextView s1txt, s2txt, s3txt ,proceed,backbtn;

    View myview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_gremarks, container, false);


        final GlobalClass objglobal = (GlobalClass) getActivity().getApplicationContext();

        sk1 = (SeekBar) myview.findViewById(R.id.seek1);
        s1txt = (TextView) myview.findViewById(R.id.seek1txt);
        sk1.setMax(40);

        sk2 = (SeekBar) myview.findViewById(R.id.seek2);
        s2txt = (TextView) myview.findViewById(R.id.seek2txt);
        sk2.setMax(40);

        sk3 = (SeekBar) myview.findViewById(R.id.seek3);
        s3txt = (TextView) myview.findViewById(R.id.seek3txt);
        sk3.setMax(12);
        backbtn = (TextView)myview.findViewById(R.id.txtback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });

        proceed = (TextView)myview.findViewById(R.id.txt2);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentmanager = getFragmentManager();
               // Toast.makeText(getActivity(), "yyhkh", Toast.LENGTH_SHORT).show();
                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new EnglishProficiency()).addToBackStack("D")
                        .commit();
            }
        });

        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i + 130;
                //Log.d("iiiii", String.valueOf(i));
                float percent = ((float) seekBar.getProgress()) / (float) seekBar.getMax();
                int width = seekBar.getWidth() - 2 * seekBar.getThumbOffset();
                int answer = ((int) (width * percent + seekBar.getThumbOffset() - s1txt.getWidth() / 2));
                s1txt.setText("" + i);
                s1txt.setX(answer);
                objglobal.setQuant(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i + 130;
                //Log.d("iiiii", String.valueOf(i));
                float percent = ((float) seekBar.getProgress()) / (float) seekBar.getMax();
                int width = seekBar.getWidth() - 2 * seekBar.getThumbOffset();
                int answer = ((int) (width * percent + seekBar.getThumbOffset() - s2txt.getWidth() / 2));
                s2txt.setText("" + i);
                s2txt.setX(answer);
                objglobal.setVerbal(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sk3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                float progrss = (float) i / 2;
                float percent = ((float) seekBar.getProgress()) / (float) seekBar.getMax();
                int width = seekBar.getWidth() - 2 * seekBar.getThumbOffset();
                int answer = ((int) (width * percent + seekBar.getThumbOffset() - s3txt.getWidth() / 2));
                s3txt.setText("" + progrss);
                s3txt.setX(answer);
                objglobal.setAwa(progrss);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        return myview;
    }




}


