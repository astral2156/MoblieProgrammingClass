package com.example.a13.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    final static String STUDENT_DISPLAY_KEY = "STUDENT";
    final static String CHOICE_KEY = "CHOICE";
    final static String VALUE = "VALUE";
    final static int NAME_REQUEST = 1;
    final static int EMAIL_REQUEST = 2;
    final static int JOB_REQUEST = 3;
    final static int MOOD_REQUEST = 4;

    int type;
    TextView name, email, job, mood, subject;
    ImageView editNameIcon, editEmailIcon, editJobIcon, editMoodIcon;

    String pName;
    String pEmail;
    String pJob;
    String pSubject;
    int pMood;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        name = (TextView) findViewById(R.id.nameView);
        email =(TextView) findViewById(R.id.emailView);
        job = (TextView) findViewById(R.id.jobView);
        mood = (TextView) findViewById(R.id.moodView);
        subject =(TextView) findViewById(R.id.subjectView);

        editNameIcon =(ImageView) findViewById(R.id.imageButton5);
        editEmailIcon =(ImageView) findViewById(R.id.imageButton6);
        editJobIcon =(ImageView) findViewById(R.id.imageButton7);
        editMoodIcon =(ImageView) findViewById(R.id.imageButton8);

        Intent intent = getIntent();

        pName = intent.getStringExtra("name");
        pEmail = intent.getStringExtra("email");
        pJob = intent.getStringExtra("job");
        pMood =intent.getIntExtra("mood",1);
        pSubject =intent.getStringExtra("check");

        String k = String.valueOf(pMood);

        name.setText(pName);
        email.setText(pEmail);
        job.setText(pJob);
        mood.setText(k);
        subject.setText(pSubject);

        editNameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this,RadioSeekCheckActivity.class);
                startActivity(intent);
            }
        });
        editEmailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this,RadioSeekCheckActivity.class);
                startActivity(intent);
            }
        });
        editJobIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this,RadioSeekCheckActivity.class);
                startActivity(intent);
            }
        });
        editMoodIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this,RadioSeekCheckActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){

            if(requestCode == NAME_REQUEST){

            }
            if(requestCode == EMAIL_REQUEST){
            //    person.setEmail(data.getExtras().getString(VALUE));
            //    email.setText(person.getEmail());
            }
            if(requestCode == JOB_REQUEST){
            //    person.setJob(data.getExtras().getString(VALUE));
                // job.setText(person.getJob());
            }
            if(requestCode == MOOD_REQUEST){
                //person.setMood(Integer.parseInt(data.getExtras().getString(VALUE)));
                //mood.setText(person.getMood() +"% positive");
            }
        }
        else{}

    }

}

