package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView;
    int count = 0;
    Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView=findViewById(R.id.txtCounter);

    }

    public void startCounting(View view) {
        count = 0;// Revisit
        myHandler.postDelayed(Threadcount,500);
    }

    public void stopCounting(View view) {
        myHandler.removeCallbacks(Threadcount);
    }

    private Runnable Threadcount = new Runnable() {
        @Override
        public void run() {
            txtView.setText(""+count);
            count++;
            myHandler.postDelayed(Threadcount,500);
        }
    };
}