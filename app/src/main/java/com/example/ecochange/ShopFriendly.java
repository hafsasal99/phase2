package com.example.ecochange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.Model.shopfriendly;
import com.Adapters.shopfriendlyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopFriendly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopfriendlylist);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     onBackPressed();
                                                 }
                                             });
       RecyclerView shopFriendly=(RecyclerView)findViewById(R.id.shopfriendlyRecyclerView);
                List<shopfriendly> ecofriendlybrands;
                ecofriendlybrands=new ArrayList<shopfriendly>();
                shopfriendly brand1=new shopfriendly(getString(R.string.brand1),getString(R.string.desc1),R.drawable.carbonfootprint1);
                shopfriendly brand2=new shopfriendly(getString(R.string.brand2),getString(R.string.desc2),R.drawable.carbonfootprint1);
                shopfriendly brand3=new shopfriendly(getString(R.string.brand3),getString(R.string.desc3),R.drawable.carbonfootprint1);
                ecofriendlybrands.add(brand1);
                ecofriendlybrands.add(brand2);
                ecofriendlybrands.add(brand3);

                shopFriendly.setLayoutManager(new LinearLayoutManager(this));
                shopFriendly.setAdapter(new shopfriendlyAdapter(ecofriendlybrands));
            }
        }


