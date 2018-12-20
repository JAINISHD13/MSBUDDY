package com.example.anew.msbuddy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by New on 23/09/2017.
 */
public class applicationtimeline_fragment extends Fragment {
    @Nullable
   // @Override
    View myview;
    ImageView img;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       myview = inflater.inflate(R.layout.applicationtimeline, container ,false);
        img =(ImageView)myview.findViewById(R.id.img12);

        return myview;
    }
}
