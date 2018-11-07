package com.example.a13.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button CalcBtn, PrimeBtn, RSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalcBtn=findViewById(R.id.calcBtn);
        PrimeBtn=findViewById(R.id.primeBtn);
        RSBtn =findViewById(R.id.radioseekBtn);

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



    }
}
