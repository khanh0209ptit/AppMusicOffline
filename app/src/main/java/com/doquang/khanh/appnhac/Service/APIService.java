package com.doquang.khanh.appnhac.Service;

public class APIService {
    private static String base_url = "https://doquangkhanh.000webhostapp.com/Sever/";

    public static DataService getService() {
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
