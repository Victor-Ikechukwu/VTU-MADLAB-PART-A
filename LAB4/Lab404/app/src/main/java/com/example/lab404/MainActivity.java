package com.example.lab404;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer myTime;
    Drawable drawable;
    WallpaperManager wpman;
    int nextImg = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTime = new Timer();
        wpman = WallpaperManager.getInstance(this);
    }


    public void changeWallPaper(View view) {
        setWallpaper();
    }

    private void setWallpaper() {
        myTime.schedule(new TimerTask() {
            @Override
            public void run() {
                if (nextImg == 1)
                {
                    drawable = getResources().getDrawable(R.drawable.img1);
                    nextImg = 2;
                }
                else if (nextImg == 2)
                {
                    drawable = getResources().getDrawable(R.drawable.img2);
                    nextImg = 3;
                }
                else if (nextImg == 3)
                {
                    drawable = getResources().getDrawable(R.drawable.img3);
                    nextImg = 4;
                }
                else if (nextImg == 4)
                {
                    drawable = getResources().getDrawable(R.drawable.img4);
                    nextImg = 5;
                }
                else if (nextImg == 5)
                {
                    drawable = getResources().getDrawable(R.drawable.img5);
                    nextImg = 6;
                }
                else if (nextImg == 6)
                {
                    drawable = getResources().getDrawable(R.drawable.img6);
                    nextImg = 7;
                }
                else //if (nextImg == 7)
                {
                    drawable = getResources().getDrawable(R.drawable.img7);
                    nextImg = 1;
                }

                Bitmap imgBmp = ((BitmapDrawable)drawable).getBitmap();

                try {
                    wpman.setBitmap(imgBmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },30000,2000);
    }
}