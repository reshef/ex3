package com.example.owner.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Async extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        final Button button_cancel_async = findViewById(R.id.button_cancel_async);
        button_cancel_async.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Async.this, Async.class);
                startActivity(intent);

                // Code here executes on main thread after user presses button
            }
        });


        final Button button_create_asnyc = findViewById(R.id.button_create_asnyc);
        button_cancel_async.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Async.this, Async.class);
                startActivity(intent);

                // Code here executes on main thread after user presses button
            }
        });


        final Button button_start_asnyc = findViewById(R.id.button_start_asnyc);
        button_cancel_async.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Async.this, Async.class);
                startActivity(intent);

                // Code here executes on main thread after user presses button
            }
        });






    }

}
