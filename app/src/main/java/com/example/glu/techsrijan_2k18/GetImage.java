package com.example.glu.techsrijan_2k18;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GetImage {
    ArrayList<Drawable> d;
    Context context;
    ProgressDialog pDialog;
    public GetImage(Context context)
    {
        this.context = context;
        d = new ArrayList<Drawable>();
        new LoadImage().execute();
    }

    public ArrayList<Drawable> getDra()
    {
        return d;
    }


    private class LoadImage extends AsyncTask<Void , Void, Void> {

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Retrieving photos ");
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
