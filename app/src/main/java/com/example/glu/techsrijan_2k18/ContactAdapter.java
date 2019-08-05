package com.example.glu.techsrijan_2k18;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glu.techsrijan_2k18.data.InfoContact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<String> {

    private Activity context;
    private String g[];
    public ContactAdapter(@NonNull Activity context,String g[]) {
        super(context, R.layout.contactadapter,g);
        this.context = context;
        InfoContact.adddetail();
        this.g = g;
    }

    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.contactadapter, null,true);
        ImageView im = rowView.findViewById(R.id.contactimg);
        TextView des,name;
        des = rowView.findViewById(R.id.contactdes);
        name = rowView.findViewById(R.id.contactname);
        ImageButton call,fb;
        call = rowView.findViewById(R.id.contactnumnber);
        fb = rowView.findViewById(R.id.contactid);

        im.setImageResource(InfoContact.getImage(position));
        des.setText(InfoContact.getDesignation(position));
        name.setText(InfoContact.getName(position));

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",InfoContact.getNumber(position).toString(),null)));
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(InfoContact.getUri(position))));
            }
        });

        return rowView;

    };
}