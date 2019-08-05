package com.example.glu.techsrijan_2k18;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.example.glu.techsrijan_2k18.data.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Eventdescription.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Eventdescription#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Eventdescription extends Fragment implements ObservableScrollViewCallbacks {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imscroll;
    ObservableScrollView observableScrollView;
    private OnFragmentInteractionListener mListener;
    int position;
    TextView evname, evtype,evdes;
    infoevent ev;
    Infoworkshop wv;
    Button brules;
    Button breg;

    public Eventdescription() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Eventdescription.
     */
    // TODO: Rename and change types and number of parameters
    public static Eventdescription newInstance(String param1, String param2) {
        Eventdescription fragment = new Eventdescription();
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
        View v = inflater.inflate(R.layout.fragment_eventdescription, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.my_toolbar);
        toolbar.setBackgroundResource(R.drawable.app_transparent);
        toolbar.setTitle("Event Name");

        toolbar.setNavigationIcon(R.drawable.ic_action_list);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragcontainer, new ListEvent());
                        transaction.commit();
                    }
                }
        )
        ;

        Bundle b = getArguments();
         position = b.getInt("position");
         String ty = b.getString("type");
         evname = v.findViewById(R.id.evename);
         evtype = v.findViewById(R.id.evtype);
         evdes = v.findViewById(R.id.evedes);
         ev = new infoevent();

         brules  = v.findViewById(R.id.brules);
         brules.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(ev.getlink(position))));
             }
         });

         breg = v.findViewById(R.id.breg);
         breg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 swapFragment(new MainWeb());
             }
         });


        observableScrollView = (ObservableScrollView)v.findViewById(R.id.observable_sview);
        observableScrollView.setScrollViewCallbacks(this);
        imscroll = v.findViewById(R.id.imgscroll);
   //





        //

        imscroll.setImageResource(ev.getevimg(position));
        imscroll.setBackgroundResource(ev.getevimg(position));
        evname.setText(ev.getevname(position));
        evtype.setText(ev.getevtype(position));
        evdes.setText(ev.getevdes(position));
        toolbar.setTitle(ev.getevname(position));
        //toolbar.setBackgroundResource(R.drawable.app_background);
         if(ty.equals("workshops"))
         {  wv = new Infoworkshop();
         imscroll.setBackgroundResource(wv.getimg(position));
         imscroll.setImageResource(wv.getimg(position));
         evname.setText(wv.getwname(position));
         evdes.setText(wv.getwdes(position));
         evtype.setText("Workshop");
    toolbar.setTitle(wv.getwname(position));
         }








        return v;


    }
    public void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
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

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {


        imscroll.setTranslationY(scrollY/2);

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

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
