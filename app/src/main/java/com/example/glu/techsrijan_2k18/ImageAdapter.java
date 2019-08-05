package com.example.glu.techsrijan_2k18;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import android.R.integer;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter implements ListAdapter {

    ProgressDialog pDialog;

    ArrayList<Drawable> d ;

    private Context context;
    public ImageAdapter(Context context,ArrayList<Drawable> da) {
        super();
        this.context = context;
//Listeye image url si ekliyor
        d = da;
        GridViewConfig.addImageUrls();


    }
    @Override
    public int getCount() {
        return d.size();
    }

    @Override
    public Object getItem(int position) {
        return d.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {ImageView imageView;
        if(convertView==null)
        {
            imageView=new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250,250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5,5,5,5);
        }else{
            imageView=(ImageView)convertView;
        }

            if(d.isEmpty());
        else
                imageView.setImageDrawable(d.get(position));
        return imageView;
    }
    private Drawable LoadImageFromURL(String url)
    {
        try
        {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src");
            return d;
        }catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }



    private class LoadImage extends AsyncTask<Void , Void, Void> {

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Retrieving family member Details... ");
            // pDialog.setMax(16);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            pDialog.setCancelable(false);
            pDialog.show();


        }


        @Override
        protected Void doInBackground(Void... uri) {

            ArrayList<String> url = GridViewConfig.getResim_list();

            for (String u: url
                 ) {
                try
                {
                    InputStream is = (InputStream) new URL(u).getContent();
                    d.add(Drawable.createFromStream(is, "src"));

                }catch (Exception e) {
                    System.out.println(e);
                    return null;
                }



            }


return null;

        }

        @Override
        protected void onPostExecute(Void d) {
            super.onPostExecute(d);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


        }


    }
}
