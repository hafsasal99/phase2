package com.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Model.shopfriendly;
import com.example.ecochange.R;

import java.util.List;

public class shopfriendlyAdapter extends RecyclerView.Adapter<shopfriendlyAdapter.shopFriendlyViewHolder> {
    @NonNull
    private List<shopfriendly> data;
    public shopfriendlyAdapter(List<shopfriendly> data)
    {
        this.data=data;
    }
    @Override
    public shopfriendlyAdapter.shopFriendlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.shopfriendly,parent,false);
        return new shopfriendlyAdapter.shopFriendlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull shopFriendlyViewHolder holder, int position) {
        shopfriendly object=data.get(position);
        holder.title.setText(object.getCompany());
        holder.description.setText(object.getDescription());
        holder.footprint.setImageResource(object.getCarbonFootprint());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class shopFriendlyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        ImageView footprint;

        public shopFriendlyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            footprint=itemView.findViewById(R.id.carbonfootprint);

        }
    }
}


