package com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecochange.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class statistics extends AppCompatActivity {
    BarChart bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        bar=findViewById(R.id.bargraph);
        ArrayList<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(44f,0));
        entries.add(new BarEntry(88f,1));
        entries.add(new BarEntry(66f,2));


        BarDataSet dataset=new BarDataSet(entries,"x-axis");

        ArrayList<String> xaxis=new ArrayList<>();
        xaxis.add("CO2");
        xaxis.add("O2");
        xaxis.add("H2O");

        BarData bardata=new BarData(dataset);


        bar.setData(bardata);

        bar.setTouchEnabled(false);
        bar.setDragEnabled(false);
        bar.setScaleEnabled(true);
    }
}
