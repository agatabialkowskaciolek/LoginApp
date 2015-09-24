package com.example.agata.loginapp;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // String toastInfo= new String();
      //  Bundle args = new Bundle();
       // args.putString("key", getIntent().getExtras().getString("key"));
        String str =getIntent().getStringExtra("key");

        /*Bundle extras = getIntent().getExtras();

            String value = extras.getString("key");*/

       TextView textViewInCardActivity;
        textViewInCardActivity = (TextView) findViewById(R.id.textViewInCardActivity);





        String toastInfo= getIntent().getStringExtra("key");
        String name=getIntent().getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
       textViewInCardActivity.setText(toastInfo);



       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
*/

                FloatingActionButton myFab = (FloatingActionButton)  findViewById(R.id.fab);
                myFab.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(CardActivity.this,LoginActivity.class);
                        startActivity(i);
                    }
                });
            }
   //     });
    }


