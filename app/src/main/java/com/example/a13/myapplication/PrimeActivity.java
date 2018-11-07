package com.example.a13.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PrimeActivity extends AppCompatActivity {

    EditText isText;//Allow user to type a long
    TextView tv;//Show result of test
    Button isitBtn;
    String  k;
    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);

        isText = (EditText) findViewById(R.id.isitText1);
        tv = (TextView) findViewById(R.id.isitTextView);
        isitBtn = findViewById(R.id.isitBtn);

        isitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CheckPrimeClick();
                k = isText.getText().toString();
                a = Integer.parseInt(k);

                if(a==0){tv.setText("Input more than 0");}
                else if(a==1){tv.setText("1 is prime number!");}
                else{
                    for(int i=2; i<=(a/2)+1; i++) {

                        if (a % i == 0) {
                            tv.setText(a + "is not prime number..");
                            break;
                        }
                        else{
                            tv.setText(a+"is prime number!");
                        }
                    }
                }

            }
        });
    }
}