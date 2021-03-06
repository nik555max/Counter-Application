package com.example.counterapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    TextView homeContent, count;
    Handler handler;
    int countNo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btnStart);
        stop = findViewById(R.id.btnStop);
        homeContent = findViewById(R.id.tvHome);
        count = findViewById(R.id.tvCount);

        handler = new Handler();

        //onclick listner for start button

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable, 0);
            }
        });


        //onclick listner for stop button
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getApplicationContext(),"Clicked on the stop btn", Toast.LENGTH_SHORT).show();
                handler.removeCallbacks(runnable);

            }
        });
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            count.setText(""+countNo);
            countNo++;
            handler.postDelayed(this, 1000);
        }
    };
}