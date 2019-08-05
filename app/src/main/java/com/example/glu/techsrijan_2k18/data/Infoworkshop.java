package com.example.glu.techsrijan_2k18.data;

import com.example.glu.techsrijan_2k18.R;

import java.util.ArrayList;
import java.util.List;

public class Infoworkshop {
    List<String> name ;
    List<Integer> image;
    List<String> des;
    List<String> type;
    List<String> uri;

    public Infoworkshop()
    {
        name = new ArrayList<String>();
        name.add("Ethical Hacking");
        name.add("Android");
        name.add("Auto Cad");
        name.add("Robotics");
        name.add("Machine Learning");

        image = new ArrayList<Integer>();
        image.add(R.drawable.hack);
        image.add(R.drawable.android);
        image.add(R.drawable.autocad);
        image.add(R.drawable.rb);
        image.add(R.drawable.ml);

        des = new ArrayList<>();
        des.add("Get exclusive hands-on training on Ethical Hacking and Cyber Security at 2-day workshop on Ethical Hacking conducted by Techsrijan'18 in MMMUT. 100% practical learning.\n Gain Knowledge in penetration test, Sql injection Social Media vulnerability and much more." );
        des.add("A major share of hand-held devices runs on the Android Operating System - which is open source and customizable. The Android Application Development Workshop provides participants technical training on the concepts and programming methodologies needed to develop applications for mobile devices.\n");
        des.add("3-D designing and modeling on autocad Workshop mainly focuses from Basics concepts in the field of designing and increases the imagination power of the students . It is very easy to modeling on auto cad software.");
        des.add("Every year TechSrijan conduct classes for Robotics where we teach student about wired Robotics, Wireless Roborics and this time Autonomous.\n The main objective of this course is to give the participants a broad overview of the field of Robotics through numerous lectures and laboratory sessions.");
        des.add("Machine Learning is the basis for the most exciting careers in data analysis today. You'll learn the models and methods and apply them to real world situations .");



    }

   public String getwname(int position)
    {
        return name.get(position);
    }

    public String getwdes(int position)
    {
        return des.get(position);
    }

    public Integer getimg(int position)
    {
        return image.get(position);
    }

    public List<String> getName()
    {
        return name;
    }

    public List <Integer> getImage()
    {
        return image;

    }

    public int count()
    {
        return name.size();
    }


}
