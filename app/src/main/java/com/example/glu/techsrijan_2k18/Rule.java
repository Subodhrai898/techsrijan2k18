package com.example.glu.techsrijan_2k18;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Rule.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Rule#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Rule extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView img;
    private ImageButton next, prev;
    int count=0;

    private OnFragmentInteractionListener mListener;

    public Rule() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Rule.
     */
    // TODO: Rename and change types and number of parameters
    public static Rule newInstance(String param1, String param2) {
        Rule fragment = new Rule();
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
        View v = inflater.inflate(R.layout.fragment_rule, container, false);
        img = v.findViewById(R.id.pdfholder);
        next = v.findViewById(R.id.pdfnext);
        prev = v.findViewById(R.id.pdfprevious);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                render();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                render();
            }
        });

   render();
        return v;
    }

    public void render()
    {
        int resID = getResources().getIdentifier("dap.png","drawable",getActivity().getPackageName());
        img.setImageResource(resID);





        /*try
    {  int width  = img.getMaxWidth();
      int height = img.getMaxHeight();

        Bitmap bitmap = Bitmap.createBitmap(300,200,Bitmap.Config.ARGB_8888);
        File file = new File("android_asset/form1.pdf");



        PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file,ParcelFileDescriptor.MODE_READ_ONLY));

        if(count<0)
        {
            count = 0;
        }else if(count>renderer.getPageCount())
        {
            count = renderer.getPageCount();
        }
        Matrix matrix = img.getImageMatrix();
        Rect rect = new Rect(0,0,width,height);
        renderer.openPage(count).render(bitmap,null,null,PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);


        img.setImageBitmap(bitmap);
        Toast.makeText(getContext(),"pdf",Toast.LENGTH_SHORT).show();


    }catch (Exception e)
    {
        Log.e("pdf",e.toString() + " "+getContext().getFilesDir());
    }*/

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
