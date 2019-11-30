package com.example.ecochange;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.MainActivity;
import com.NewsFeedModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.Adapters.newsfeedAdapter;
import com.Progresses.progressTabs;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.statistics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.firebase.auth.FirebaseUser;
public class ScrollingActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    static final int RC_PERMISSION_READ_EXTERNAL_STORAGE = 1;
    static final int RC_IMAGE_GALLERY = 2;
    FirebaseUser fbUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        fbUser = FirebaseAuth.getInstance().getCurrentUser();
        if (fbUser == null) {
            finish();
        }
        //setContentView(R.layout.login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageButton profile=findViewById(R.id.toolbar_button3);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){


                    Intent intent= new Intent(ScrollingActivity.this,Profile.class);
                    startActivity(intent);

            }
        });
        Button navMenu = findViewById(R.id.spinner1);
        navMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout navDrawer = findViewById(R.id.drawer_layout);
                // If navigation drawer is not open yet, open it else close it.
                if(!navDrawer.isDrawerOpen(GravityCompat.START)) navDrawer.openDrawer(GravityCompat.START);

                else navDrawer.closeDrawer(GravityCompat.END);
            }
        });

        NavigationView nav=findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id= menuItem.getItemId();
                if(id==R.id.nav_item_one)
                {
                    Intent go;
                    go = new Intent(getApplicationContext(), ShopFriendly.class);
                    startActivity(go);
                }
                else if(id==R.id.nav_item_two)
                {
                    Intent go;
                    go = new Intent(getApplicationContext(), progressTabs.class);
                    startActivity(go);
                }
                else if(id==R.id.nav_item_three)
                {
                    Intent go;
                    go = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(go);
                }
                else if(id==R.id.nav_item_five)
                {
                    Intent go;
                    go = new Intent(getApplicationContext(), statistics.class);
                    startActivity(go);
                }
                return true;
            }
        });

        RecyclerView newsfeed=(RecyclerView)findViewById(R.id.newsfeed_RecyclerView);
        List<NewsFeedModel>  newsfeedContent;
        newsfeedContent=new ArrayList<NewsFeedModel>();
        NewsFeedModel obj1=new NewsFeedModel(getString(R.string.username1),getString(R.string.caption1),R.drawable.blank_profile_picture_973460_960_720,R.drawable.earth,R.drawable.support,getString(R.string.supportCount1));
        NewsFeedModel obj2=new NewsFeedModel(getString(R.string.username2),getString(R.string.caption2),R.drawable.blank_profile_picture_973460_960_720,R.drawable.canvasbag,R.drawable.support,getString(R.string.supportCount1));
        NewsFeedModel obj3=new NewsFeedModel(getString(R.string.username3),getString(R.string.caption3),R.drawable.blank_profile_picture_973460_960_720,R.drawable.bicyle,R.drawable.support,getString(R.string.supportCount1));
        newsfeedContent.add(obj1);
        newsfeedContent.add(obj2);
        newsfeedContent.add(obj3);
        newsfeed.setLayoutManager(new LinearLayoutManager(this));
        newsfeed.setAdapter(new newsfeedAdapter(newsfeedContent));



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//       fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });
        FloatingActionButton floatingActionButton =
                (FloatingActionButton) findViewById(R.id.floating_action_button);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click.
                try {
                    startActivity(new Intent(ScrollingActivity.this, UploadPost.class));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
              //uploadImage(view);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.toolbar, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_spinner) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    public void uploadImage(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, RC_PERMISSION_READ_EXTERNAL_STORAGE);
        } else {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, RC_IMAGE_GALLERY);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RC_PERMISSION_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, RC_IMAGE_GALLERY);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_IMAGE_GALLERY && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            StorageReference storageRef = FirebaseStorage.getInstance().getReference();
            StorageReference imagesRef = storageRef.child("images");
            StorageReference userRef = imagesRef.child(fbUser.getUid());
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = fbUser.getUid() + "_" + timeStamp;
            final StorageReference fileRef = userRef.child(filename);

            UploadTask uploadTask = fileRef.putFile(uri);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    Toast.makeText(ScrollingActivity.this, "Upload failed!\n" + exception.getMessage(), Toast.LENGTH_LONG).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> downloadUrl =fileRef.getDownloadUrl();
                    Toast.makeText(ScrollingActivity.this, "Upload finished!", Toast.LENGTH_SHORT).show();
                }
            });




}
    }
}