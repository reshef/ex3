package com.example.owner.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button button_asnyc = findViewById(R.id.button_asnyc);
        button_asnyc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Async.class);
                startActivity(intent);

                // Code here executes on main thread after user presses button
            }
        });


        final Button button_handler = findViewById(R.id.button_handler);
        button_handler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(MainActivity.this, Handler_re.class);
                startActivity(intent);
            }
        });
    }
}
