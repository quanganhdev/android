package com.example.apnhac.service;

public class APIsevecie {
    private static String base_url = "https://appandroidnhac.000webhostapp.com/sever/";
    public static Datasevice getsevice(){
        return apiretrofitclient.getclient(base_url).create(Datasevice.class);
    }
}
