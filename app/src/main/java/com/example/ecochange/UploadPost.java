package com.example.ecochange;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UploadPost extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ActionBar actionbar;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_post);
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // actionbar=getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("Upload Post");
        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        firebaseAuth=FirebaseAuth.getInstance();
        checkUserStatus();
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    protected void onStart()
    {
        super.onStart();
        checkUserStatus();
    }
    protected void onResume()
    {
        super.onResume();
        checkUserStatus();
    }
    private void checkUserStatus()
    {
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null)
        {

        }
        else
        {
            Toast.makeText(this,"No user ID ",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,ScrollingActivity.class));
            finish();

        }
    }
}
