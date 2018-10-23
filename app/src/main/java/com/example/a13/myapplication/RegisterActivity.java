package com.example.a13.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.content.ContentValues;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText idText = (EditText) findViewById(R.id.editId);
        final EditText ageText = (EditText) findViewById(R.id.editAge);
        final EditText emailText = (EditText) findViewById(R.id.editEmail);
        final EditText passText = (EditText) findViewById(R.id.editPassword);

        //저장 버튼
        Button entryButton = (Button) findViewById(R.id.saveBtn); //add member in DB
        entryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                String age = ageText.getText().toString();
                String email = emailText.getText().toString();
                String password = passText.getText().toString();

                if (id.equals("")) {

                    Toast.makeText(RegisterActivity.this, "Please Input id", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues insertValues = new ContentValues();
                    insertValues.put("id", id);
                    insertValues.put("age", age);
                    insertValues.put("email", email);
                    insertValues.put("password", password);
                    db.insert("registeration", id, insertValues);
                    Toast.makeText(RegisterActivity.this, "Successfully saved!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //업뎃 버튼
        Button updateButton = (Button) findViewById(R.id.updateBtn);
        updateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                String age = ageText.getText().toString();

                if (id.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please Input id",
                            Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues updateValues = new ContentValues();
                    updateValues.put("age", age);
                    db.update("registeration", updateValues, "id=?", new String[]{id});
                }
            }
        });
        //삭제 버튼
        Button deleteButton = (Button) findViewById(R.id.deleteBtn);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                String age = ageText.getText().toString();

                if (id.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please Input id",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.delete("registeration", "id=?", new String[]{id});
                    Toast.makeText(RegisterActivity.this, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //모두 선택 버튼
        Button dataBaseButton = (Button) findViewById(R.id.selectallBtn);
        dataBaseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent dbIntent = new Intent(RegisterActivity.this,
                        ShowDataBase.class);
                startActivity(dbIntent);

            }
        });
        Button SelcectButton = (Button) findViewById(R.id.selectBtn);
        SelcectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();

                if (id.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please Input id",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Cursor c = db.rawQuery("Select * From registeration Where id='" + id + "'", null);
                    if (c.moveToFirst()) {
                        idText.setText(c.getString(1));
                        ageText.setText(c.getString(2));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Data Not Found",
                                Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(RegisterActivity.this, ShowDataBaseOnly.class);
                    startActivity(intent);
                }
            }
        });


    }
}
