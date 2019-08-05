package com.example.glu.techsrijan_2k18.data;

import com.example.glu.techsrijan_2k18.R;

import java.util.ArrayList;
import java.util.List;

public class InfoContact {

    private static List<Integer> imag;


    private static List<String> designation;
    private static  List<String> name;
    private static List<String> number;
    private static List<String> uri;

    public static void adddetail()
    {   imag = new ArrayList<Integer>();


         designation = new ArrayList<String>();
         designation.add("Chairman(IEEE Student)");
        designation.add("Chairman(SAE Student)");
         designation.add("Vice Chairman(IEEE Student)");
         designation.add("Vice Chairman(IEEE Student)");
        designation.add("Vice Chairperson(SAE Student)");

         designation.add("Treasurer(IEEE Student)");
         designation.add("Secretary(IEEE Student)");
        designation.add("Joint Secretary(IEEE Student)");
         designation.add("Technical Head(IEEE Student)");
         designation.add("Technical Head(IEEE Student)");
         designation.add("Technical Head(IEEE Student)");



         name =  new ArrayList<>();
         name.add("Ekansh Bajpai");
        name.add("Shivank Pandey");

        name.add("Sahil Sahu");
        name.add("Abhishek Chauhan");
        name.add("Shikhar Srivastav");
        name.add("Satyajeet Kunwar");
        name.add("Tanmay Kumar");
        name.add("Rakesh Singh");
        name.add("Utkarsh Sharma");
        name.add("Anshul Gupta");
        name.add("Gaurav Kumar Sharma");


    uri  =  new ArrayList<>();
        uri.add("https://www.facebook.com/technoekansh");
        uri.add("https://www.facebook.com/shivank07");
        uri.add("https://www.facebook.com/sahil.32bit");
        uri.add("https://www.facebook.com/profile.php?id=100005144640237");
        uri.add("https://www.facebook.com/shikhar.srivastava.710");
        uri.add("https://www.facebook.com/satyajeet.kunwar");
        uri.add("https://www.facebook.com/ts.tanmay89");
        uri.add("https://www.facebook.com/rsrak4");
        uri.add("https://www.facebook.com/utkarsh.sharma1610");
        uri.add("https://www.facebook.com/anshulgupta101196");
        uri.add("https://www.facebook.com/profile.php?id=100002655260915");



        imag.add(R.drawable.ekansh);
        imag.add(R.drawable.shivang);
        imag.add(R.drawable.sah);
        imag.add(R.drawable.abh);
        imag.add(R.drawable.shikar);
        imag.add(R.drawable.satya);
        imag.add(R.drawable.tan);
        imag.add(R.drawable.raka);
        imag.add(R.drawable.ut);
        imag.add(R.drawable.anshu);
        imag.add(R.drawable.gaurav);


        number = new ArrayList<>();
        number.add("+919450796566");
        number.add("+919651035907");
        number.add("+918574804166");
        number.add("+919454116779");
        number.add("+917376399001");
        number.add("+917505288190");
        number.add("+918934911694");
        number.add("+919889991430");
        number.add("+918127484410");
        number.add("+918756441150");
        number.add("+919450796566");






    }
 public static Integer getImage(int positon)
 {
     return imag.get(positon);
 }

    public static String getDesignation(int positon) {
        return designation.get(positon);
    }

    public static String getName(int position) {
        return name.get(position);
    }

    public static String getNumber(int positon) {
        return number.get(positon);
    }

    public static String getUri(int positon) {
        return uri.get(positon);
    }

}
