package com.example.a13.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button CalcBtn, PrimeBtn, RSBtn, TabBtn, MapsBtn, VideoBtn, TableViewBtn, NaviBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalcBtn=findViewById(R.id.calcBtn);
        PrimeBtn=findViewById(R.id.primeBtn);
        RSBtn =findViewById(R.id.radioseekBtn);
        TabBtn = findViewById(R.id.TabBtn);
        MapsBtn = findViewById(R.id.mapsBtn);
        VideoBtn = findViewById(R.id.videoBtn);
        NaviBtn = findViewById(R.id.naviBtn);
        TableViewBtn = findViewById(R.id.tableviewBtn);


        CalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CalcActivity.class);
                startActivity(intent);
            }
        });

        PrimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrimeActivity.class);
                startActivity(intent);
            }
        });

        RSBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, RadioSeekCheckActivity.class);
                startActivity(intent);
            }
        });

        TabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tabbed.class);
                startActivity(intent);
            }
        });

        MapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class); // should be change
                startActivity(intent);
            }
        });

        VideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class); // should be change
                startActivity(intent);
            }
        });

        NaviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class); // should be change
                startActivity(intent);
            }
        });

        TableViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TableViewActivity.class); // should be change
                startActivity(intent);
            }
        });

    }
}
