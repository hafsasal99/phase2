package com.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecochange.R;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.recyclerViewHolder> {
    public String[] data;
    public recyclerViewAdapter(String[] data){
        this.data=data;
    }
    @NonNull
    @Override
    public recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.recycler_row,parent,false);

        return new recyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewHolder holder, int position) {
        String text=data[position];
        holder.text.setText(text);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class recyclerViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TextView bullet;
        public recyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            bullet=itemView.findViewById(R.id.bullet);
            text=itemView.findViewById(R.id.text);
        }
    }

}

