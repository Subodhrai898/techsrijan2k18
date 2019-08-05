package com.example.glu.techsrijan_2k18;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CaseAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> maintitle;

    private final List<Integer> imgid;
  private  String mm[] ;



    public CaseAdapter(@NonNull Activity context, List<String> maintitle,List<Integer> imgid,String [] mm) {
        super(context, R.layout.caselist,mm);
        this.context = context;
        this.maintitle = maintitle;

        this.imgid = imgid;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.caselist, null,true);
        ImageView imageView = rowView.findViewById(R.id.workshopimage);
        TextView textView = rowView.findViewById(R.id.workshopname);


        imageView.setBackgroundResource(imgid.get(position));
        textView.setText(maintitle.get(position));



        return rowView;

    };

}
