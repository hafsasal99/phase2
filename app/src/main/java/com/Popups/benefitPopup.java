package com.Popups;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecochange.R;
import com.Adapters.recyclerViewAdapter;

public class benefitPopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benefit_popup);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=(int)(dm.widthPixels*0.8);
        int height=(int)(dm.heightPixels*0.4);

        getWindow().setLayout(width,height);

        RecyclerView rView= findViewById(R.id.list_points);
        rView.setLayoutManager(new LinearLayoutManager(this));
        String[] suggs={getString(R.string.benefit)};
        rView.setAdapter(new recyclerViewAdapter(suggs));
    }

}
