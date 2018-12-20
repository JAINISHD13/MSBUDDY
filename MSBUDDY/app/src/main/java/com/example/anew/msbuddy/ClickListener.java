package com.example.anew.msbuddy;

import android.view.View;

/**
 * Created by New on 30/09/2017.
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
