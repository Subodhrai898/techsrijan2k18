package com.example.glu.techsrijan_2k18;


import java.util.ArrayList;

public class GridViewConfig {

    private static ArrayList<String> resim_list=new ArrayList<String>();

    public static ArrayList<String> getResim_list() {
        return resim_list;
    }

    public static void setResim_list(ArrayList<String> resim_list) {
        GridViewConfig.resim_list = resim_list;
    }

    public static void addImageUrls(){

        for(int i=1;i<10;i++)
        resim_list.add("https://techsrijan.org/gallery/"+i+".jpg");

    }








}
