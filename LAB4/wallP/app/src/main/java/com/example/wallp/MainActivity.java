package com.example.wallp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    boolean running;

    //To load all seven images at the same time, create an array of type in
    //Iterate through them, OBSERVE: The images will be populated & displayed on the left Side
    int[] imgC = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,R.drawable.img5, R.drawable.img6, R.drawable.img7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
//NOTE: CTRL+Q = Quick Documentation Lookup, CTRL+P = Parameters for Selected Method
    @Override
    public void onClick(View view) {
        if(!running){ // Refer Dr. Harish Kumar's Video for the timer explanation
            new Timer().schedule(new myTimer(), 0, 3000);//create an object of Timer()
            running = true;
        }
    }

    private class myTimer extends TimerTask {
        @Override
        public void run() {
                try{ //Try to Handle the Exception by using the WallPaperManager class
                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                    Random random = new Random();//Creates an Object of Random Class
                    //OBSERVATION: This was changinging randomly. That's incorrect, so, we need a better approach
                    wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),imgC[random.nextInt(7)]));
                    //It will turn Red, make sure you enable Permission

                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        //It will show RED Underline, you have to RightClick->Show Context Action->Implement Run Methods
        //and the error will be gone



    }
}