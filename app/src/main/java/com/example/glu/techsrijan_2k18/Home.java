package com.example.glu.techsrijan_2k18;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ViewPager viewPager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Toolbar toolbar;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIODE_MS = 3000;
    TextView tv;
    ImageButton ev,ph,wk,ab;
    Button bba,bbinvite,cama;


    String s = "This year we present before you techSRIJAN'18 with similar extravaganza but with a tinge of more advanced technologies and a dynamic line up of events. This techno-management festival comprises a plethora of events ranging from the most exciting ones like roboKRITI, abINITIO, junkyard WARS and bridgeKRITI to most brain stimulating ones like hardRACHNA, techPRASTUTI, resoNOVA and techSHILP. The event has always attracted the masses from all over the country, with strength of more than 3000 witnessing the event every year. To providee the event a shade of more fun and thrill techSRIJAN'18 has its own surfeit of informal events such as Rock shows and fest nights";

    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        //toolbar.setBackgroundResource(R.drawable.app_background);
       Toolbar toolbar = getActivity().findViewById(R.id.my_toolbar);
       toolbar.setBackgroundResource(R.drawable.app_transparent);
       TextView t = v.findViewById(R.id.tstxt);
       t.setText(s);
       tv = v.findViewById(R.id.form);
       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
              transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
               transaction.replace(R.id.fragcontainer, new Explorer());
               transaction.commit();

           }
       });
        cama = v.findViewById(R.id.campusam);
        cama.setOnClickListener(this);

        toolbar.setBackgroundResource(R.drawable.app_transparent);
        toolbar.setTitle("Home");
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://techsrijan.org/")));

                    }
                }
        );


        viewPager = v.findViewById(R.id.homeview);
        Viewpagera viewpagera = new Viewpagera(getContext());
        viewPager.setAdapter(viewpagera);


        final Handler handler = new Handler();
          final Runnable Update = new Runnable() {
              @Override
              public void run() {
                  if(currentPage==5)
                  {
                      currentPage = 0;
                  }
                  viewPager.setCurrentItem(currentPage++,true);
              }
          };

          timer = new Timer();
          timer.schedule(new TimerTask() {
              @Override
              public void run() {
                  handler.post(Update);
              }
          },DELAY_MS,PERIODE_MS);


          ev = v.findViewById(R.id.hevent);
          ph = v.findViewById(R.id.hgallery);
          wk = v.findViewById(R.id.hworkshop);
          ab = v.findViewById(R.id.haboutus);
          bbinvite = v.findViewById(R.id.binvite);
          bbinvite.setOnClickListener(this);


          ev.setOnClickListener(this);
          ph.setOnClickListener(this);
          wk.setOnClickListener(this);
          ab.setOnClickListener(this);
          bba = v.findViewById(R.id.babout);
          bba.setOnClickListener(this);




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
    public void onClick(View v) {
        Fragment f = new Home();
        switch (v.getId())
        {
            case R.id.hevent:
                f = new Event();
                break;
            case R.id.hgallery:
                f = new Gallery();

                break;
            case R.id.hworkshop:
                f = new workshop();
                break;
            case R.id.haboutus:
                f = new Aboutus();
                break;
            case R.id.babout:
                f = new Contact();
                break;
            case R.id.binvite:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Your Friend Invite to Techsrijan 2k18 log on now https://techsrijan.org/");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            case R.id.campusam:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://techsrijan.org/ca/")));
                break;

        }

        swapFragment(f);



    }


    public void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragcontainer, fragment);
        transaction.commit();
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
    {
        private Context context;
        private LayoutInflater layoutInflater;
        private Integer[] img = {R.drawable.lar,R.drawable.backdrop,R.drawable.logo1,R.drawable.iogo5,R.drawable.logo2};
        private String[] name = {"Event 2","Event 2","Event 3"};
        public Viewpagera(Context context)
        {
            this.context = context;
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, final int position)
        {
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.homeviewpager,null);
            ImageView im = view.findViewById(R.id.homeimg);

            im.setBackgroundResource(img[position]);


            ViewPager vp = (ViewPager)container;
            vp.addView(view,0);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container,int position, Object object)
        {
            ViewPager vp = (ViewPager)container;
            View view = (View)object;
            vp.removeView(view);
        }
    }

}
