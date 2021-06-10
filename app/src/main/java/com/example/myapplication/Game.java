package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    ArrayList<TextView> tileArr = new ArrayList<TextView>();
    Button up, down;

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
        turn();

        up = findViewById(R.id.up1);
        down = findViewById(R.id.down);
    }

    private void turn() {
        int flag = 0;
        while (flag == 0) {
            int rnd = (int) (Math.random() * 15);
            if (tileArr.get(rnd).getVisibility() == View.INVISIBLE) {
                tileArr.get(rnd).setVisibility(View.VISIBLE);
                tileArr.get(rnd).setText("2");
                flag++;
            }
        }
    }


    public void disable() {
        for (int i = 0; i < tileArr.size(); i++) {
            tileArr.get(i).setVisibility(View.INVISIBLE);
            tileArr.get(i).setText("0");
        }
    }

    public void swipeUp() {

        for (int i = 4; i < tileArr.size(); i++) {
            if (isAvailableIndex(i)) {
                int j =i;
                while (j>=4 &&tileArr.get(j - 4).getVisibility() == View.INVISIBLE) {
                        tileArr.get(j - 4).setVisibility(View.VISIBLE);
                        tileArr.get(i).setVisibility(View.INVISIBLE);
                        tileArr.get(j - 4).setText(tileArr.get(j).getText());
                        tileArr.get(i).setText("0");
                        j -= 4;

                }
            }
        }
        for (int i = 4; i < tileArr.size(); i++) {
            if (isAvailableIndex(i) && Integer.parseInt(tileArr.get(i).getText().toString()) == Integer.parseInt(tileArr.get(i - 4).getText().toString())) {
                tileArr.get(i).setVisibility(View.INVISIBLE);
                tileArr.get(i - 4).setText(Integer.parseInt(tileArr.get(i).getText().toString()) + Integer.parseInt(tileArr.get(i).getText().toString()) + "");
            }
        }
        turn();
    }


    public void swipeDown() {
        for (int i = 11; i < tileArr.size(); i--) {
            if (isAvailableIndex(i)) {
                while (tileArr.get(i + 4).getVisibility() == View.INVISIBLE) {
                    tileArr.get(i + 4).setText(tileArr.get(i).getText());
                    tileArr.get(i + 4).setVisibility(View.VISIBLE);
                }
            }
        }
        for (int i = 11; i < tileArr.size(); i--) {
            if (isAvailableIndex(i) && Integer.parseInt(tileArr.get(i).getText().toString()) == Integer.parseInt(tileArr.get(i + 4).getText().toString())) {
                tileArr.get(i).setVisibility(View.INVISIBLE);
                tileArr.get(i + 4).setText(Integer.parseInt(tileArr.get(i).getText().toString()) + Integer.parseInt(tileArr.get(i).getText().toString()) + "");
            }
        }
        turn();
    }


    public void swipeRight() {
    }

    public void swipeLeft() {
    }

    public boolean isAvailableIndex(int i) {
        if (tileArr.get(i).getVisibility() == View.VISIBLE) {
            return true;
        }
        return false;

    }

    public void drag(View view) {
        if (view == up) {
            swipeUp();
        }
        if (view == down) {
            swipeDown();
        }
    }
}