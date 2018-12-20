package com.example.anew.msbuddy;

/**
 * Created by Vaibhavi on 25-Feb-18.
 */
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Uni_Detail> arrayList;
    private LayoutInflater inflater;
    private boolean isListView;
    private int selectedPosition = -1;

    public MyAdapter(Context context, ArrayList<Uni_Detail> arrayList, boolean isListView) {
        this.context = context;
        this.arrayList = arrayList;
        this.isListView = isListView;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;


        if (view == null)
        {
            viewHolder = new ViewHolder();
            //inflate the layout on basis of boolean
            if (isListView)
                view = inflater.inflate(R.layout.uni_details, viewGroup, false);
            viewHolder.label = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) view.getTag();
        }
        final Uni_Detail upload = arrayList.get(i);

        viewHolder.label.setText(upload.getName());
       // Log.d("adapter uni name",upload.getName());
        //Log.d("Rankkkkk",""+upload.getRank());
        viewHolder.label.setTag(i);

        viewHolder.label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final GlobalClass objglobal= (GlobalClass)context;

                Uni_Detail obj=arrayList.get((Integer) v.getTag());
                objglobal.setName(obj.getName());
                objglobal.setRank(obj.getRank());
                objglobal.setWeb(obj.getWeb());
                objglobal.setDescription(obj.getDescription());
                objglobal.setFees(obj.getFees());
                objglobal.setLocation(obj.getLocation());


                Log.d("Name",""+obj.getRank());

                Intent educationIntent = new Intent(context, UniversityWhole.class);
                educationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(educationIntent);
               // itemCheckChanged(v);
            }
        });
        return view;
    }
    //On selecting any view set the current position to selectedPositon and notify adapter
    private void itemCheckChanged(View v) {
        selectedPosition = (Integer) v.getTag();
        notifyDataSetChanged();
    }
    private class ViewHolder {
        private TextView label;

    }
    //Return the selectedPosition item
    public String getSelectedItem() {
        if (selectedPosition != -1) {
            //Toast.makeText(context, "Selected Item : " + arrayList.get(selectedPosition), Toast.LENGTH_SHORT).show();
            //Toast.makeText(context, "Selected Item : " + arrayList.get(selectedPosition), Toast.LENGTH_SHORT).show();
            //return arrayList.get(selectedPosition);
        }
        return "";
    }
    //Delete the selected position from the arrayList
    public void deleteSelectedPosition() {
        if (selectedPosition != -1) {
            arrayList.remove(selectedPosition);
            selectedPosition = -1;//after removing selectedPosition set it back to -1
            notifyDataSetChanged();
        }
    }
}