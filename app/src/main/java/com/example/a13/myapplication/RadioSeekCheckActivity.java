package com.example.a13.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class RadioSeekCheckActivity extends AppCompatActivity{

        /*
        원래 프로젝트에서 Person 객체 안쓰고 다시해보기
        데이터 주고받기 튜토리얼 : http://recipes4dev.tistory.com/75
        bundle 로 putExtras로 데이터 보내기 intent
        bundle getIntent.getExtras
        */
        EditText name, email;
        TextView seekbarResult;
        RadioGroup radioGroup;
        RadioButton radio1, radio2, radio3;
        SeekBar moodSeekbar;
        Button submit;
        int mood=0;
        Intent intent;

        CheckBox cb1,cb2,cb3,cb4;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_radioseekcheck);

            name = (EditText) findViewById(R.id.editText);
            email =(EditText) findViewById(R.id.editText2);
            radioGroup =(RadioGroup) findViewById(R.id.radioGroup);
            radio1 =(RadioButton) findViewById(R.id.radioButton);
            radio2 =(RadioButton) findViewById(R.id.radioButton2);
            radio3 =(RadioButton) findViewById(R.id.radioButton3);
            submit =(Button) findViewById(R.id.button);
            intent = getIntent();
            cb1 = (CheckBox) findViewById(R.id.checkBox1);
            cb2 = (CheckBox) findViewById(R.id.checkBox2);
            cb3 = (CheckBox) findViewById(R.id.checkBox3);
            cb4 = (CheckBox) findViewById(R.id.checkBox4);
            seekbarResult = (TextView) findViewById(R.id.seekBarResult);

            moodSeekbar = (SeekBar) findViewById(R.id.moodSeekBar);
            moodSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    //seekBar.setProgress(progress);
                    seekbarResult.setText(progress+"%");
                    mood=progress;
                }

                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            submit =(Button) findViewById(R.id.button);
            submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    if(name.getText().toString().length()==0){
                        Toast.makeText(RadioSeekCheckActivity.this,"add name", Toast.LENGTH_LONG).show();
                    } else if (email.getText().toString().length()==0){
                        Toast.makeText(RadioSeekCheckActivity.this,"add email", Toast.LENGTH_LONG).show();

                    } else {
                        String pName = name.getText().toString();
                        String pEmail = email.getText().toString();
                        String Job = "";
//                        int mood = moodSeekbar.getProgress();
                        switch (radioGroup.getCheckedRadioButtonId()){
                            case R.id.radioButton:
                                Job ="Computer Engineer";
                                break;
                            case R.id.radioButton2:
                                Job="Doctor";
                                break;
                            case R.id.radioButton3:
                                Job="Banker";
                                break;

                        }
                        String a ="";
                        if (cb1.isChecked()){
                            a = a+"Mobile Programming\n";
                        }
                        if(cb2.isChecked()){
                            a= a+"Database\n";
                        }
                        if(cb3.isChecked()){
                            a= a+"Algorithms\n";
                        }
                        if(cb4.isChecked()){
                            a= a+"Data Structure\n";
                        }
                        Intent intent = new Intent(RadioSeekCheckActivity.this, DisplayActivity.class);
                        intent.putExtra("name", pName);
                        intent.putExtra("email",pEmail);
                        intent.putExtra("job",Job);
                        intent.putExtra("mood", mood);
                        intent.putExtra("check",a);

                        startActivityForResult(intent,1);

                    }


                }
            });


        }

        public void onRadioButtonClicked(View view){
            boolean checked = ((RadioButton) view).isChecked();

            switch (view.getId()){
                case R.id.radioButton:
                    if(checked) {
                        break;
                    }
                case R.id.radioButton2:

                    if(checked){
                        break;}

                case R.id.radioButton3:
                    if(checked){
                        break;
                    }
            }
        }




    }
