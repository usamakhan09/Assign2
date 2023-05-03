package com.example.project39.Adapter;

import com.example.project39.Interface.CategoryAPI_Interface;

import retrofit.RestAdapter;

public class CatAPI {

    public static CategoryAPI_Interface getClient()
    {
        String remoteHost = "https://reqres.in";
        String localHost = "http://192.168.3.102:5000";
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(localHost) .build();
        CategoryAPI_Interface api = adapter.create(CategoryAPI_Interface.class);
        return api; // return the APIInterface object
    }
}