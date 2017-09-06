package com.example.domingl.lottietest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lottie Animation
        LottieAnimationView animationViewRemote = (LottieAnimationView) findViewById(R.id.animation_view_remote);
        animationViewRemote.setAnimation("remote.json");
        animationViewRemote.loop(true);
        animationViewRemote.playAnimation();
    }
}
