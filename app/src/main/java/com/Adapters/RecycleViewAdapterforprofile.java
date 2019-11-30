package com.Adapters;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Model.profileModel;
import com.example.ecochange.R;

import java.util.List;

public class RecycleViewAdapterforprofile extends RecyclerView.Adapter<RecycleViewAdapterforprofile.recyclerViewHolder> {
    public List<profileModel> data;
    public RecycleViewAdapterforprofile(List<profileModel> data){
        this.data=data;
    }
    @NonNull
    @Override
    public recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.recyclerow,parent,false);

        return new recyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewHolder holder, int position) {
        profileModel obj= data.get(position);
        holder.date.setText(obj.getDate());
        holder.name.setText(obj.getName());
        holder.post.setText(obj.getPostcontent());
        holder.profileimage.setImageResource(obj.getProfilepic());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class recyclerViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView date;
        TextView post;
        ImageView profileimage;

        public recyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameofpost);
            date=itemView.findViewById(R.id.dateofpost);
            post= itemView.findViewById(R.id.postcontent);
            profileimage= itemView.findViewById(R.id.profileimage);
        }
    }

}


