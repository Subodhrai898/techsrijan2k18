package com.example.glu.techsrijan_2k18;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import  com.example.glu.techsrijan_2k18.data.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link workshop.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link workshop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class workshop extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView workshoplist;
    CaseAdapter caseAdapter;
    Infoworkshop we;
    String[] maintitle = {"Android","Ethical Hacking","Guest Lectures","Robotics","MAchine Learning"};

    private OnFragmentInteractionListener mListener;

    public workshop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment workshop.
     */
    // TODO: Rename and change types and number of parameters
    public static workshop newInstance(String param1, String param2) {
        workshop fragment = new workshop();
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
        View v = inflater.inflate(R.layout.fragment_workshop, container, false);
        we = new Infoworkshop();
        workshoplist = v.findViewById(R.id.workshop);
        caseAdapter = new CaseAdapter(getActivity(),we.getName(),we.getImage(),maintitle);
        workshoplist.setAdapter(caseAdapter);

        Toolbar toolbar = getActivity().findViewById(R.id.my_toolbar);
        toolbar.setBackgroundResource(R.drawable.app_transparent);
        toolbar.setTitle("Workshops");


        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        Fragment f = new Home();

                        transaction.replace(R.id.fragcontainer, f);
                        transaction.commit();
                    }
                }
        )
        ;

     workshoplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
             Fragment f = new Eventdescription();
             Bundle b= new Bundle();
             b.putString("type","workshops");
             b.putInt("position",position);
             f.setArguments(b);


             transaction.replace(R.id.fragcontainer, f);
             transaction.commit();
         }
     });



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
