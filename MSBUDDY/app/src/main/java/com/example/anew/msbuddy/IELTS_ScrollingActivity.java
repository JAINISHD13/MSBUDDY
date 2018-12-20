package com.example.anew.msbuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class IELTS_ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts__scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        int n = getIntent().getIntExtra("article_position",-1);
        TextView large_text = (TextView)findViewById(R.id.large_text);
        switch(n)
        {
            case 0:large_text.setText(R.string.ielts_1);
                setTitle("IELTS Exam");
                break;
            case 1:large_text.setText(R.string.ielts_2);
                setTitle("IELTS Exam Fee");
                break;
            case 2:large_text.setText(R.string.ielts_3);
                setTitle("IELTS Exam Pattern");
                break;
            case 3:large_text.setText(R.string.ielts_4);
                setTitle("IELTS Evaluation");
                break;

            case 4:large_text.setText(R.string.ielts_5);
                setTitle("IELTS Dates");
                break;
            case 5:large_text.setText(R.string.ielts_6);
                setTitle("IELTS Preparation Tips");
                break;
            case 6:large_text.setText(R.string.ielts_7);
                setTitle("Speaking Section Tips");
                break;
            case 7:large_text.setText(R.string.ielts_8);
                setTitle("Reading Section Tips");
                break;
            case 8:large_text.setText(R.string.ielts_9);
                setTitle("Writing Section Tips");
                break;
            case 9:large_text.setText(R.string.ielts_10);
                setTitle("Listening Section Tips");
                break;
            default:large_text.setText("ERROR");


        }
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);

    }
}
