package com;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Adapters.recyclerViewAdapter;
import com.Popups.benefitPopup;
import com.Popups.suggestionPopup;
import com.example.ecochange.R;


public class MainActivity extends AppCompatActivity {
    recyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item_screen);


        Button addnewitem=findViewById(R.id.addItemButton);
        addnewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //startActivity(new Intent(MainActivity.this,NewItemPopup.class));
                final AlertDialog.Builder inBox=new AlertDialog.Builder(MainActivity.this);
                View inView;
                inView = getLayoutInflater().inflate(R.layout.newitem,null);
                final EditText nameofItem=inView.findViewById(R.id.nameofItem);
                final EditText time=inView.findViewById(R.id.time);
                final EditText type=inView.findViewById(R.id.typeItem);
                Button addItem=inView.findViewById(R.id.addItem);

                inBox.setView(inView);
                final AlertDialog dialog=inBox.create();
                dialog.show();

                addItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!nameofItem.getText().toString().isEmpty() &&
                           !time.getText().toString().isEmpty()&&
                                !type.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        else
                            Toast.makeText(MainActivity.this,"Please fill all the fields",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });

        final Button sugg1=findViewById(R.id.sbutton1);
        sugg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, suggestionPopup.class));
            }
        });

        Button sugg2=findViewById(R.id.sbutton2);
        sugg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,suggestionPopup.class));

            }
        });

        Button ben1=findViewById(R.id.bbutton1);
        ben1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, benefitPopup.class));
            }
        });

        Button ben2=findViewById(R.id.bbutton2);
        ben2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,benefitPopup.class));
            }
        });


    }


}
