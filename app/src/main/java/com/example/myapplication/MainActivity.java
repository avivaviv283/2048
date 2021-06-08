package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button goGame;
    Intent toGame;
    private GestureDetectorCompat gdc = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goGame=findViewById(R.id.toGame);

    }

    public void toGame(View view) {
        toGame= new Intent(this,Game.class);
        startActivity(toGame);
    }
}