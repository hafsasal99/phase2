package com.example.ecochange;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Model.profileModel;
import com.Adapters.RecycleViewAdapterforprofile;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar2);
        toolbar.setNavigationIcon(R.drawable.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RecyclerView object = findViewById(R.id.allposts);
        List<profileModel> userprofileposts = new ArrayList<profileModel>();

        profileModel post1 = new profileModel(getString(R.string.post1_date), getString(R.string.post1_content));
        profileModel.setName(getString(R.string.userprofile_name));
        profileModel.setProfilepic(R.drawable.earth);
        profileModel post2= new profileModel( getString(R.string.post2_date), getString(R.string.post2_content));
        profileModel.setProfilepic(R.drawable.canvasbag);
        userprofileposts.add(post1);
        userprofileposts.add(post2);

        object.setLayoutManager(new LinearLayoutManager(this));
        object.setAdapter(new RecycleViewAdapterforprofile(userprofileposts));
    }

}
