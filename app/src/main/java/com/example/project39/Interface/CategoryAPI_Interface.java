
package com.example.project39.Interface;

import com.example.project39.Adapter.CategoryListResponse;

import retrofit.Callback;
import retrofit.http.GET;

public interface CategoryAPI_Interface {
    @GET("/api/users") public void getUsersList(
            Callback<CategoryListResponse> callback);
}
