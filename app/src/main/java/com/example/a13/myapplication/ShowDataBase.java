package com.example.a13.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowDataBase extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_database);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        MyOpenHelper helper = new MyOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        // query메소드 실행
        Cursor c = db.query("registeration", new String[] { "id", "age", "email", "password"}, null,
                null, null, null, null);

        boolean mov = c.moveToFirst();
        while (mov) {
            TextView textView = new TextView(this);
            textView.setText(String.format("id : %s  ,  age : %d ,     email   :   %s,    password   :   %s", c.getString(0), c.getInt(1), c.getString(2), c.getString(3)));
            mov = c.moveToNext();
            layout.addView(textView);
        }
        c.close();
        db.close();
    }



}
