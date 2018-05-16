package com.example.owner.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Handler_re extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        final Button createButton = findViewById(R.id.button_create_handler);
        final Button startButton = findViewById(R.id.button_start_handler);
        final Button cancelButton = findViewById(R.id.button_cancel_handler);
        final TextView textView_handler = findViewById(R.id.textView_handler);



        Looper mainLooper = Looper.getMainLooper();
        final Handler mainHandler = new Handler(mainLooper) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case (MyHandlerThread.WRITE_DONE):
                        textView_handler.setText("Done!");
                        break;
                    case (MyHandlerThread.WRITE_NUMBER):
                        textView_handler.setText(msg.obj.toString());
                        break;
                    case (MyHandlerThread.WRITE_CANCEL):
                        textView_handler.setText("Cancelled!");
                        break;
                }

            }
        };

        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);

        final MyHandlerThread[] thread = new MyHandlerThread[1];

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thread[0] == null) {
                    thread[0] = new MyHandlerThread(mainHandler);

                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thread[0] != null) {
                    handler.post(thread[0]);
                } else {

                    Snackbar.make(view, "startButton", 500).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thread[0] != null)
                {
                    thread[0].cancel();
                }
                else
                {
                    Snackbar.make(view, "cancelButton", 500).show();
                }

            }
        });
//        final TextView textView_handler = findViewById(R.id.textView_handler);
//
//        final Button button_cancel_handler = findViewById(R.id.button_cancel_handler);
//        button_cancel_handler.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Handler.this, Async.class);
//                startActivity(intent);
//
//                // Code here executes on main thread after user presses button
//            }
//        });
//        final Button button_create_handler = findViewById(R.id.button_create_handler);
//        button_create_handler.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Handler.this, Async.class);
//                startActivity(intent);
//
//                // Code here executes on main thread after user presses button
////                MyTheredHandler my_handler_thread=new MyTheredHandler("myHandler",);
////                my_handler_thread.start();
//            }
//        });
//
//        final Button button_start_handler = findViewById(R.id.button_start_handler);
//        button_start_handler.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Handler.this, Async.class);
//                startActivity(intent);
//
//                // Code here executes on main thread after user presses button
//            }
//        });



    }


}
