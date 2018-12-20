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

public class TOEFLMarks extends Fragment {
    @Nullable
    // @Override
    private SeekBar sk1,sk2,sk3,sk4;
    private TextView seekreadtxt, seeklistentxt, seekwritentxt, seekspeaktxt,proceed;

            View myview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_toeflmarks, container ,false);

        final GlobalClass objglobal= (GlobalClass)getActivity().getApplicationContext();

        sk1 =(SeekBar)myview. findViewById(R.id.seek1);
        seekreadtxt =(TextView) myview.findViewById(R.id.seekreadtxt);
        sk1.setMax(30);

        sk2 =(SeekBar)myview.findViewById(R.id.seek2);
        seeklistentxt =(TextView) myview.findViewById(R.id.seeklistentxt);
        sk2.setMax(30);

        sk3 =(SeekBar)myview.findViewById(R.id.seek3);
        seekwritentxt =(TextView) myview.findViewById(R.id.seekwrientxt);
        sk3.setMax(30);

        sk4 =(SeekBar)myview.findViewById(R.id.seek4);
        seekspeaktxt =(TextView) myview.findViewById(R.id.seekspeaktxt);
        sk4.setMax(30);

        proceed = (TextView)myview.findViewById(R.id.txt2);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentmanager = getFragmentManager();

                fragmentmanager.beginTransaction()
                        .replace(R.id.content_frame
                                ,new UniversityDetail()).addToBackStack(null)
                        .commit();
            }
        });
        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //Log.d("iiiiiiiiiiiiiiiii", String.valueOf(i));
                float percent = ((float)seekBar.getProgress())/(float) seekBar.getMax();
                int width = seekBar.getWidth() - 2*seekBar.getThumbOffset();
                int answer =((int)(width*percent +seekBar.getThumbOffset() - seekreadtxt.getWidth()/2));
                seekreadtxt.setText(""+i);
                seekreadtxt.setX(answer);
                objglobal.setReading(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {             }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }

        });

        sk2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //Log.d("iiiii", String.valueOf(i));
                float percent = ((float)seekBar.getProgress())/(float) seekBar.getMax();
                int width = seekBar.getWidth() - 2*seekBar.getThumbOffset();
                int answer =((int)(width*percent +seekBar.getThumbOffset() - seeklistentxt.getWidth()/2));
                seeklistentxt.setText(""+i);
                seeklistentxt.setX(answer);
                objglobal.setListening(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });

        sk3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                //Log.d("iiiii", String.valueOf(i));
                float percent = ((float)seekBar.getProgress())/(float) seekBar.getMax();
                int width = seekBar.getWidth() - 2*seekBar.getThumbOffset();
                int answer =((int)(width*percent +seekBar.getThumbOffset() - seekwritentxt.getWidth()/2));
                seekwritentxt.setText(""+i);
                seekwritentxt.setX(answer);
                objglobal.setWriting(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });


        sk4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                //Log.d("iiiii", String.valueOf(i));
                float percent = ((float)seekBar.getProgress())/(float) seekBar.getMax();
                int width = seekBar.getWidth() - 2*seekBar.getThumbOffset();
                int answer =((int)(width*percent +seekBar.getThumbOffset() - seekspeaktxt.getWidth()/2));
                seekspeaktxt.setText(""+i);
                seekspeaktxt.setX(answer);
                objglobal.setSpeaking(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });
        return myview;
    }




    }
