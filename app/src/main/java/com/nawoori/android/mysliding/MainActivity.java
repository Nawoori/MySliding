package com.nawoori.android.mysliding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout page;
    Button button;
    Animation translateLeft;
    Animation translateright;

    boolean isPageOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = (LinearLayout) findViewById(R.id.page);

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateright = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingAnimationListner listner = new SlidingAnimationListner();
        translateLeft.setAnimationListener(listner);
        translateright.setAnimationListener(listner);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPageOpen) {
                    page.startAnimation(translateright);

                } else {
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);
                }

            }
        });
    }
        class  SlidingAnimationListner implements Animation.AnimationListener{

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isPageOpen) {
                    page.setVisibility(View.INVISIBLE);
                    button.setText("열기");
                    isPageOpen = false;
                }else{
                    button.setText("닫기");
                    isPageOpen = true;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }

    }
