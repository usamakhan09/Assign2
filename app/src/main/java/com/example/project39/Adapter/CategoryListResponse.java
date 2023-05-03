package com.example.project39.Adapter;

import com.example.project39.Domain.CategoryDomain;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryListResponse {
    @SerializedName("data")
    public List<CategoryDomain> data = new ArrayList<>();
}
