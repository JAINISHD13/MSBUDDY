package com.example.anew.msbuddy;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by New on 23/09/2017.
 */
public class profileevaluator_fragment extends Fragment {
    @Nullable
   // @Override
    View myview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.profileevaluator, container ,false);
        Button evaluator = (Button) myview.findViewById(R.id.btnevaluate);



/*
        int Quant = Integer.parseInt(Gre_Q1);
        int Verbal = Integer.parseInt(Gre_V1);
        int total_gre= Quant+Verbal;
        int total_toefl= Integer.parseInt(Toefl_L1)+Integer.parseInt(Toefl_R1)+Integer.parseInt(Toefl_S1)+Integer.parseInt(Toefl_W1);
        int grade=Integer.parseInt(UG1);
        int worl=Integer.parseInt(WE1);
*/
        evaluator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Context context;
                EditText Gre_Q = (EditText) myview.findViewById(R.id.edittext_quant);
                EditText Gre_V= (EditText) myview.findViewById(R.id.edittext_verbal);
                EditText Gre_A= (EditText) myview.findViewById((R.id.edittext_awa));
                EditText Toefl_R= (EditText) myview.findViewById(R.id.edittext_reading);
                EditText Toefl_S= (EditText) myview.findViewById(R.id.edittext_speaking);
                EditText Toefl_L= (EditText) myview.findViewById(R.id.edittext_listening);
                EditText Toefl_W= (EditText) myview.findViewById(R.id.edittext_writing);
                EditText UG= (EditText) myview.findViewById(R.id.edittext_percentage);
                EditText WE= (EditText) myview.findViewById(R.id.edittext_work_experience);
                EditText RP =(EditText) myview.findViewById(R.id.edittext_research_paper);
                String Gre_Q1= Gre_Q.getText().toString();
                String Gre_V1= Gre_V.getText().toString();
                String Gre_A1= Gre_A.getText().toString();
                String Toefl_R1= Toefl_R.getText().toString();
                String Toefl_S1= Toefl_S.getText().toString();
                String Toefl_L1= Toefl_L.getText().toString();
                String Toefl_W1= Toefl_W.getText().toString();
                String UG1= UG.getText().toString();
                String WE1= WE.getText().toString();
                String RP1=RP.getText().toString();

                context=arg0.getContext();
             //   Toast.makeText(context,Gre_Q1,Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(context,Evaluated_Result.class);
                myIntent.putExtra("gre_ver",Gre_V1);
                myIntent.putExtra("gre_qun",Gre_Q1);
                myIntent.putExtra("gre_awa",Gre_A1);
                myIntent.putExtra("toefl_rea",Toefl_R1);
                myIntent.putExtra("toefl_lis",Toefl_L1);
                myIntent.putExtra("toefl_spe",Toefl_S1);
                myIntent.putExtra("toefl_wri",Toefl_W1);

                myIntent.putExtra("percentage",UG1);
                myIntent.putExtra("workexp",WE1);
                myIntent.putExtra("research",RP1);
                startActivity(myIntent);


            }
        });

        return myview;
    }
}
