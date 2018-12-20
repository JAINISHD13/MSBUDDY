package com.example.anew.msbuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GRE_ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gre__scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int n = getIntent().getIntExtra("article_position",-1);
        TextView large_text = (TextView)findViewById(R.id.large_text);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        switch(n)
        {
            case 0:large_text.setText(R.string.gre_1);
                setTitle("GRE Exam");
                break;
            case 1:large_text.setText(R.string.gre_2);
                setTitle("GRE Exam Fee");
                break;
            case 2:large_text.setText(R.string.gre_3);
                setTitle("GRE  Eligibility");
                break;
            case 3:large_text.setText(R.string.gre_4);
                setTitle("GRE Exam Pattern");
                break;
            case 4:large_text.setText(R.string.gre_5);
                setTitle("GRE Exam Evaluation");
                break;
            case 5:large_text.setText(R.string.gre_6);
                setTitle("Quantitative Section");
            break;
            case 6:large_text.setText(R.string.gre_7);
                setTitle("Verbal Reasoning");
                break;
            case 7:large_text.setText(R.string.gre_8);
                setTitle("Analytical Writing Section");
                break;
            default:large_text.setText("ERROR");


        }


      //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       // fab.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
           //     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             ///           .setAction("Action", null).show();
          //  }
       // });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);

    }
}
