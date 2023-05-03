package com.example.project39.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project39.Domain.PopularDomain;
import com.example.project39.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView title,feeTxt,descriptionTxt,numberOrderTxt;
    private ImageView plusBtn,minusBtn,picFood;
    private PopularDomain object;

    int number1=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        intiView();
        getBundle();

    }
    private void getBundle(){
        object=(PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawabl",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picFood);
        title.setText(object.getTitle());
        feeTxt.setText("$"+object.getFees());
        descriptionTxt.setText(object.getDescp());
        numberOrderTxt.setText(number1);


        plusBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        number1=number1+1;
                        numberOrderTxt.setText(String.valueOf(number1));

                    }
                }
        );
        minusBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       if(number1>1){
                           number1=number1-1;
                       }
                       numberOrderTxt.setText(String.valueOf(number1));
                                            }
                }

        );
    }
    private void intiView() {
        addToCartBtn=findViewById(R.id.addtoCartBtn);
        title=findViewById(R.id.titleText);
        feeTxt=findViewById(R.id.fees);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberorderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);

    }
}