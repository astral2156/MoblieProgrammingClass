package com.example.a13.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcActivity extends AppCompatActivity {


    EditText e2, e3, e4;
    String input1, input2;
    Button b1, b2,b3,b4;
    int RESULT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        e2 =(EditText) findViewById(R.id.editText2);
        e3 =(EditText) findViewById(R.id.editText3);
        e4 =(EditText) findViewById(R.id.editText4);


        b1=(Button) findViewById(R.id.button3);
        b2=(Button) findViewById(R.id.button4);
        b3=(Button) findViewById(R.id.button5);
        b4=(Button) findViewById(R.id.button6);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input1 = e2.getText().toString();
                input2 = e3.getText().toString();
                RESULT =Integer.parseInt(input1)+Integer.parseInt(input2);
                e4.setText(Integer.toString(RESULT));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input1 = e2.getText().toString();
                input2 = e3.getText().toString();
                RESULT =Integer.parseInt(input1)-Integer.parseInt(input2);
                e4.setText(Integer.toString(RESULT));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input1 = e2.getText().toString();
                input2 = e3.getText().toString();
                RESULT =Integer.parseInt(input1)*Integer.parseInt(input2);
                e4.setText(Integer.toString(RESULT));
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input1 = e2.getText().toString();
                input2 = e3.getText().toString();
                RESULT =Integer.parseInt(input1)/Integer.parseInt(input2);
                e4.setText(Integer.toString(RESULT));
            }
        });


    }
}
