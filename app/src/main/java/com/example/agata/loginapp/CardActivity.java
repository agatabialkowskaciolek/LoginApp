package com.example.agata.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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


        String str = getIntent().getStringExtra("key");
        TextView textViewInCardActivity;
        textViewInCardActivity = (TextView) findViewById(R.id.textViewInCardActivity);
        String toastInfo = getIntent().getStringExtra("key");
        String name = getIntent().getStringExtra("name");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        textViewInCardActivity.setText(toastInfo);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(CardActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

}


