package com.example.a13.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    Button Login_Btn;
    Button Register_Btn;
//
    SQLiteDatabase db;
    MyOpenHelper openHelper;
    Cursor cursor;
    EditText _id, _pw;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //
        openHelper = new MyOpenHelper(this);
        db = openHelper.getReadableDatabase();
        //
        Login_Btn = findViewById(R.id.Login_Btn);
        Register_Btn = findViewById(R.id.Register_Btn);
        //
        _id =(EditText) findViewById(R.id.Login_ID);
        _pw =(EditText) findViewById(R.id.Login_Password);
        //
        Login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Lid = _id.getText().toString();
                String Lpw = _pw.getText().toString();

                cursor = db.rawQuery("SELECT *FROM " + MyOpenHelper.TABLE_NAME + " WHERE " + MyOpenHelper.COL_1 + "=? AND " + MyOpenHelper.COL_4 + "=?", new String[]{Lid, Lpw});

                if(cursor !=null){
                    if(cursor.getCount()>0){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);


                    } else{
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

            }


            });



        Register_Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}
