package com.example.anew.msbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class firstpage extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_firstpage);
        RelativeLayout r1 = (RelativeLayout)findViewById(R.id.relative_layout);
        r1.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        return true;
    }
}
