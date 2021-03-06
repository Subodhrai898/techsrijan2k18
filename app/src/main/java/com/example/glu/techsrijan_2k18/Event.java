package com.example.glu.techsrijan_2k18;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.glu.techsrijan_2k18.data.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Event.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Event#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Event extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ViewPager viewPager;

    private OnFragmentInteractionListener mListener;

    public Event() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Event.
     */
    // TODO: Rename and change types and number of parameters
    public static Event newInstance(String param1, String param2) {
        Event fragment = new Event();
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
        View v =  inflater.inflate(R.layout.fragment_event, container, false);
        viewPager = v.findViewById(R.id.eventview);
        Viewpagera viewpagera = new Viewpagera(getContext());
        viewPager.setAdapter(viewpagera);
        //toolbar.setBackgroundResource(R.drawable.app_background);
        Toolbar toolbar = getActivity().findViewById(R.id.my_toolbar);
        toolbar.setBackgroundResource(R.drawable.app_transparent);
        toolbar.setTitle("Events");


        toolbar.setNavigationIcon(R.drawable.ic_action_list);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        swapFragment(new ListEvent());
                    }
                }
        )
                ;




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




    private class Viewpagera extends PagerAdapter
    {    infoevent ev;
        private Context context;
        private View des;
        private LayoutInflater layoutInflater;
        private Integer[] img = {R.drawable.app_background,R.drawable.bk,R.drawable.button_background};
        private String[] name = {"Event 2","Event 2","Event 3"};
        public Viewpagera(Context context)
        {
            this.context = context;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              des =  layoutInflater.inflate(R.layout.customeevnt,null);
              ev = new infoevent();
        }

        @Override
        public int getCount() {
            return ev.getsize();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, final int position)
        {
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.customeevnt,null);
            des = view;
            ImageView im = view.findViewById(R.id.imgc);
            TextView tv = view.findViewById(R.id.eventname);

            Button b = view.findViewById(R.id.btexplore);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment f = new Eventdescription();
                    Bundle b = new Bundle();
                    b.putInt("position",position);
                    b.putString("type","event");
                    f.setArguments(b);
                    swapFragment(f);
                }
            });



            im.setBackgroundResource(ev.getevimg(position));
            tv.setText(ev.getevname(position));
            view.setTag("myview"+position);

            ViewPager vp = (ViewPager)container;
            vp.addView(view,0);
            return view;
        }

        public View getView()
        {
            return des;}

        @Override
        public void destroyItem(ViewGroup container,int position, Object object)
        {
            ViewPager vp = (ViewPager)container;
            View view = (View)object;
            vp.removeView(view);
        }
    }
}
