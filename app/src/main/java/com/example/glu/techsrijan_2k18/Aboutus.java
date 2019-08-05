package com.example.glu.techsrijan_2k18;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Aboutus.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Aboutus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Aboutus extends Fragment implements ObservableScrollViewCallbacks,View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
  ObservableScrollView observableScrollView;
  ImageView im2;
  private TextView about;
 ImageButton batech, bfb, bmmm;
    private OnFragmentInteractionListener mListener;

    public Aboutus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Aboutus.
     */
    // TODO: Rename and change types and number of parameters
    public static Aboutus newInstance(String param1, String param2) {
        Aboutus fragment = new Aboutus();
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
        View v =  inflater.inflate(R.layout.fragment_aboutus, container, false);

        about = v.findViewById(R.id.tvabout);
        about.setText("\n" +
                "Madan Mohan Malaviya University of Technology, Gorakhpur has been a benchmark in imparting technical experience for the last 56 years. For the past 18 years the IEEE Student Branch along with SAE India Collegiate Club of the University has been organising the annual techno management fest of MMMUT, techSRIJAN to patronise technical excellence and innovation.\n" +
                "TechSRIJAN witnesses a footfall of over 3000 people across the nation.\n" +
                "\n" +
                "Believe us, we'll be back soon with a bang. ");

  batech = v.findViewById(R.id.batech);
  bfb = v.findViewById(R.id.bafb);
  bmmm =v.findViewById(R.id.bammmut);
  batech.setOnClickListener(this);
  bmmm.setOnClickListener(this);
  bfb.setOnClickListener(this);


             observableScrollView = v.findViewById(R.id.about_observal);
             im2 = v.findViewById(R.id.aboutimg);
        observableScrollView.setScrollViewCallbacks(this);



    return v;

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

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        im2.setTranslationY(scrollY/2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

    @Override
    public void onClick(View v) {
        String uri = "http:mmmut.ac.in";
        switch (v.getId())
        {
            case R.id.batech:
                uri = "https://techsrijan.org";
                break;
            case R.id.bafb:
                uri = "https://www.facebook.com/techSRIJAN/";
                break;
            case R.id.bammmut:
                uri = "http:mmmut.ac.in";
                break;
        }

        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(uri)));


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
}
