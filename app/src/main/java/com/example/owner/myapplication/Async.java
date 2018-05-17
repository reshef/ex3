package com.example.owner.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Async extends AppCompatActivity {

    TextView counterlook_re;
    Button createButton_re, startButton_re, cancelButton_rej;
    int counter;
    AsyncCounter counterTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        counter = 1;
        counterlook_re = findViewById(R.id.textView_async);
        createButton_re = findViewById(R.id.button_create_asnyc);
        startButton_re = findViewById(R.id.button_start_asnyc);
        cancelButton_rej = findViewById(R.id.button_cancel_async);


        createButton_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterTask = new AsyncCounter();
            }
        });

        startButton_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    counterTask.execute(20);

                }
                catch (NullPointerException e)
                {
                    Toast.makeText(v.getContext(), "Must create task before running",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancelButton_rej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    counterTask.cancel(true);
                }
                catch (NullPointerException e)
                {
                    Toast.makeText(v.getContext(), "Must create task before running",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private class AsyncCounter extends AsyncTask<Integer, Integer, String>
    {
        @Override
        protected String doInBackground(Integer... params) {
            for(; counter <= params[0]; counter++)
            {
                try {
                    Thread.sleep(500);
                    publishProgress(counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Done!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            counterlook_re.setText(Integer.toString(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            counterlook_re.setText(s);
        }

        @Override
        protected void onCancelled() {
            counterlook_re.setText("Cancelled");
        }
    }
}


//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.Button;
//
//public class Async extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_async);
//
//        final Button button_cancel_async = findViewById(R.id.button_cancel_async);
//        button_cancel_async.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Async.this, Async.class);
//                startActivity(intent);
//
//                // Code here executes on main thread after user presses button
//            }
//        });
//
//
//        final Button button_create_asnyc = findViewById(R.id.button_create_asnyc);
//        button_cancel_async.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Async.this, Async.class);
//                startActivity(intent);
//
//                // Code here executes on main thread after user presses button
//            }
//        });
//
//
//        final Button button_start_asnyc = findViewById(R.id.button_start_asnyc);
//        button_cancel_async.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Async.this, Async.class);
//                startActivity(intent);
//
//                // Code here executes on main thread after user presses button
//            }
//        });
//
//
//
//
//
//
//    }
//
//}
