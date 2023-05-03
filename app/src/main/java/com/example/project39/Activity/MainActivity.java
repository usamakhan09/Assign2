package com.example.project39.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.project39.Adapter.CatAPI;
import com.example.project39.Adapter.CategoryAdapter;
import com.example.project39.Adapter.CategoryListResponse;
import com.example.project39.Adapter.PopularAdapter;
import com.example.project39.Domain.CategoryDomain;
import com.example.project39.Domain.PopularDomain;
import com.example.project39.R;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private ArrayList<CategoryDomain> Categories = new ArrayList<>();
    private RecyclerView catlist,poplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerviewCategoryList();
        recyclerviewPopularList();
    }

    private void recyclerviewCategoryList() {
        CatAPI.getClient().getUsersList(new Callback<CategoryListResponse>() {

            @Override
            public void success(CategoryListResponse categoryListResponse, Response response) {
                Log.d("TAG", "Total Users: " + response.getBody());
                CategoryListResponse categories =  categoryListResponse;
                if (categories != null) {
                    Categories.addAll(categories.data);

                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("TAG","Response = "+error.toString());
            }



        });
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        catlist = findViewById(R.id.catlist);
        catlist.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category= new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("HotDog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdapter(Categories);
        catlist.setAdapter(adapter);
    }

    public void recyclerviewPopularList()
    {
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        poplist=findViewById(R.id.popularlist);
        poplist.setLayoutManager(linearLayoutManager);

        ArrayList<PopularDomain> popular = new ArrayList<>();
        popular.add(new PopularDomain("Pepperoni Pizza","Slices pepperoni, mozzarella cheese, fresh olives, ground black pepper,pizza sauce","pop_1",9.76));
        popular.add(new PopularDomain("Cheese Burger","Beef, Cheddar Cheese, Special Sauce, served with fresh Lettuce","pop_2",8.76));
        popular.add(new PopularDomain("Vegetable Pizza","Vegetable Oil, Olive Oil, Mozzarella cheese, Pitted Kalamata, Cherry Tomatoes","pop_3",7.5));

        adapter2 = new PopularAdapter(popular);
        poplist.setAdapter(adapter2);

    }

}