package com.Popups;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.ecochange.R;

public class calculateCFPPopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_cfppopup);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=(int)(dm.widthPixels*0.8);
        int height=(int)(dm.heightPixels*0.6);

        getWindow().setLayout(width,height);

    }
}




