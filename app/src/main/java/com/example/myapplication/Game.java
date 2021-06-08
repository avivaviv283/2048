package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    ArrayList<TextView> tileArr = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tileArr.add(findViewById(R.id.t01));
        tileArr.add(findViewById(R.id.t02));
        tileArr.add(findViewById(R.id.t03));
        tileArr.add(findViewById(R.id.t04));
        tileArr.add(findViewById(R.id.t05));
        tileArr.add(findViewById(R.id.t06));
        tileArr.add(findViewById(R.id.t07));
        tileArr.add(findViewById(R.id.t08));
        tileArr.add(findViewById(R.id.t09));
        tileArr.add(findViewById(R.id.t10));
        tileArr.add(findViewById(R.id.t11));
        tileArr.add(findViewById(R.id.t12));
        tileArr.add(findViewById(R.id.t13));
        tileArr.add(findViewById(R.id.t14));
        tileArr.add(findViewById(R.id.t15));
        tileArr.add(findViewById(R.id.t16));
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity(this);
        disable();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void disable() {
        for (int i = 0; i < tileArr.size(); i++) {
            tileArr.get(i).setVisibility(View.INVISIBLE);

        }
    }

    public void swipeUp() {

        for (int i = 4; i < tileArr.size(); i++) {
            if (tileArr.get(i - 4).getVisibility() == View.VISIBLE) {
                tileArr.get(i).setVisibility(View.INVISIBLE);
                tileArr.get(i - 4).setText(Integer.parseInt(tileArr.get(i).getText().toString()) + Integer.parseInt(tileArr.get(i).getText().toString()) + "");
            }
            if (tileArr.get(i - 4).getVisibility() == View.INVISIBLE) {
                tileArr.get(i).setVisibility(View.INVISIBLE);
                
            }

        }
    }

    public void swipeDown() {
    }

    public void swipeRight() {
    }

    public void swipeLeft() {
    }

}