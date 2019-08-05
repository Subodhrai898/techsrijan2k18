package com.example.glu.techsrijan_2k18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Splash extends AppCompatActivity {
    private android.os.Handler mwait = new android.os.Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());

        ImageView image= (ImageView) findViewById(R.id.roto);

        image.startAnimation(rotate);

        ImageView im2 = findViewById(R.id.roto2);
        RotateAnimation rr = new RotateAnimation(180,0,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
           rr.setDuration(5000);
           rr.setInterpolator(new LinearInterpolator());
           im2.startAnimation(rr);

           mwait.postDelayed(new Runnable() {
               @Override
               public void run() {
                   day();
               }
           },5000);






    }
    public void day()
    {
        Intent intent = new Intent(getApplicationContext(),Ask.class);
        startActivity(intent);
        finish();
    }
}
