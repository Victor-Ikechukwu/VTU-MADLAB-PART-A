package com.example.l5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Handler myHandle = new Handler();//Create an object of class Handler
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.txtCounter);
    }

    public void startCounter(View view) {
        count=0; //This ensures that i-values starts afresh from
        //0 instead of resuming.
        myHandle.postDelayed(Threadcount, 100);
    }

    public void stopCounter(View view) {
        myHandle.removeCallbacks(Threadcount);
    }

    public Runnable Threadcount = new Runnable() {
        @Override
        public void run() {
            tv.setText(""+count);
            count++;
            myHandle.postDelayed(Threadcount,100);
        }
    };
}