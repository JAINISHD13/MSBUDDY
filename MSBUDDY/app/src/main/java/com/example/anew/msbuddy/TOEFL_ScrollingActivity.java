package com.example.anew.msbuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TOEFL_ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toefl__scrolling);
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
            case 0:large_text.setText(R.string.toefl_1);
                setTitle("TOEFL Exam");
                break;
            case 1:large_text.setText(R.string.toefl_2);
                setTitle("TOEFL Exam Fee");
                break;
            case 2:large_text.setText(R.string.toefl_3);
                setTitle("TOEFL Exam Pattern");
                break;
            case 3:large_text.setText(R.string.toefl_4);
                setTitle("TOEFL Exam Evaluation");
                break;
            case 4:large_text.setText(R.string.toefl_5);
                setTitle("TOEFL Preparation Tips");
                break;
            case 5:large_text.setText(R.string.toefl_6);
                setTitle("Improve Speaking Score");
                break;
            case 6:large_text.setText(R.string.toefl_7);
                setTitle("Improve Reading Score");
                break;
            case 7:large_text.setText(R.string.toefl_8);
                setTitle("Improve Listening Score");
                break;
            default:large_text.setText("ERROR");


        }

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);

    }
}
