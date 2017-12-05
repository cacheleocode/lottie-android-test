package com.example.domingl.lottie_android_test;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    // configuration
    boolean isLoop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lottie Animation
        final LottieAnimationView animationViewTest = findViewById(R.id.animation_view_test);
        animationViewTest.setAnimation("test.json");
        animationViewTest.loop(isLoop);
        animationViewTest.playAnimation();

        // handler
        final Handler handler = new Handler();

        animationViewTest.addAnimatorListener(new AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                animationViewTest.pauseAnimation();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // wait to start animating after 1.5s
                        animationViewTest.playAnimation();
                    }
                }, 1500);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // stay on last frame then animate after 1.5s
                        animationViewTest.playAnimation();
                    }
                }, 1500);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
