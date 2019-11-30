package com.Progresses;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ecochange.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class monthlyProgress extends Fragment implements View.OnClickListener {
    LineChart linech;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.monthly,container,false);
        linech = (LineChart) view.findViewById(R.id.monthlyGraph);

        LineDataSet set=new LineDataSet(data(),"monthly");
        ArrayList<ILineDataSet> msets=new ArrayList<>();
        msets.add(set);

        LineData line1=new LineData(msets);
        linech.setData(line1);
        linech.invalidate();

        Button calCFP=view.findViewById(R.id.calCFP);
        calCFP.setOnClickListener(this);
        return view;
    }
    private ArrayList<Entry> data(){
        ArrayList<Entry> vals=new ArrayList<Entry>();
        vals.add(new Entry(0,60));
        vals.add(new Entry(1,30));
        vals.add(new Entry(2,40));
        vals.add(new Entry(3,90));

        return vals;
    }

    @Override
    public void onClick(View view) {

        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.calcfp);
        dialog.setCancelable(true);

        dialog.show();
    }
}