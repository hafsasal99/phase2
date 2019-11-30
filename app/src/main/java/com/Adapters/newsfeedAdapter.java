package com.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.NewsFeedModel;
import com.example.ecochange.R;

import java.util.List;

public class newsfeedAdapter extends RecyclerView.Adapter<newsfeedAdapter.newsfeedViewHolder> {
    @NonNull
    private List<NewsFeedModel> data;
    public newsfeedAdapter(List<NewsFeedModel> data)
    {
        this.data=data;
    }
    @Override
    public newsfeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.newsfeed,parent,false);
        return new newsfeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsfeedViewHolder holder, int position) {
        NewsFeedModel object=data.get(position);
        holder.caption.setText(object.getCaption());
        holder.username.setText(object.getUsername());
        holder.photo.setImageResource(object.getPhoto());
        holder.profileImage.setImageResource(object.getProfilePhoto());
        holder.Status.setImageResource(object.getSupportStatus());
        holder.SupportCount.setText(object.getSupportCount());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class newsfeedViewHolder extends RecyclerView.ViewHolder{
        ImageView profileImage;
        TextView caption;
        TextView username;
        ImageView photo;
        ImageView Status;
        TextView SupportCount;
        public newsfeedViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage=itemView.findViewById(R.id.profile_image);
            username=itemView.findViewById(R.id.textView);
            caption=itemView.findViewById(R.id.textView2);
            photo=itemView.findViewById(R.id.imageView);
            Status=itemView.findViewById(R.id.imageButton);
            SupportCount=itemView.findViewById(R.id.textView3);
        }
    }
}
