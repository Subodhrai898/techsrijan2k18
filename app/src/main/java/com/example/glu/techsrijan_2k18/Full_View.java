package com.example.glu.techsrijan_2k18;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Full_View.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Full_View#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Full_View extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String uri;
    int position = 1;
    ProgressDialog pDialog;
    Drawable d;

    ImageView im;
    ArrayList<String> uris ;
    ImageButton inext,iprev;

    private OnFragmentInteractionListener mListener;

    public Full_View() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Full_View.
     */
    // TODO: Rename and change types and number of parameters
    public static Full_View newInstance(String param1, String param2) {
        Full_View fragment = new Full_View();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_full__view, container, false);
        Bundle b = getArguments();
        position = b.getInt("position");
        GridViewConfig.addImageUrls();
        uris = GridViewConfig.getResim_list();
        im = v.findViewById(R.id.fullview);

        inext = v.findViewById(R.id.innext);
        iprev = v.findViewById(R.id.inprev);
        inext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<10)
                {
                    swapFragment(new Full_View(),position+1);
                }
            }
        });
  iprev.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          if(position>0)
          {
              swapFragment(new Full_View(),position-1);
          }
      }
  });



  new LoadImage().execute();





    return v;

    }

    public void swapFragment(Fragment fragment,int position) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        Bundle b = new Bundle();
        b.putInt("position",position);
        fragment.setArguments(b);
        transaction.replace(R.id.fragcontainer, fragment);
        transaction.commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private class LoadImage extends AsyncTask<Void , Void, Void> {

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Retrieving photos ");
            // pDialog.setMax(16);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            pDialog.setCancelable(false);
            pDialog.show();


        }


        @Override
        protected Void doInBackground(Void... uri) {


            try
            {
                InputStream is = (InputStream) new URL(uris.get(position)).getContent();
                d = Drawable.createFromStream(is, "src");

            }catch (Exception e) {
                System.out.println(e);
                return null;
            }






            return null;

        }

        @Override
        protected void onPostExecute(Void da) {
            super.onPostExecute(da);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            if(d != null) {
                im.setImageDrawable(d);
            }
        }


    }
}
