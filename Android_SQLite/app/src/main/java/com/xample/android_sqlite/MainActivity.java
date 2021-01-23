package com.xample.android_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.xample.android_sqlite/stu.db",
                        null);
            }
        });
        // 创建表
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("create table student(_id int,name varchar(20),age int)");
            }
        });
        // 插入数据
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("insert into student values(1001,'Jack',20)");
                db.execSQL("insert into student values(1002,'Rose',21)");
                db.execSQL("insert into student values(1003,'Tom',18)");
            }
        });
        // 查询数据
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.query("student",null,null,null,
                        null, null,null);
                SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                        MainActivity.this,R.layout.listview_item,c,
                        new String[]{"_id","name","age"},new int[]{R.id.tv1,R.id.tv2,R.id.tv3}
                );
                ListView lv = findViewById(R.id.listView);
                lv.setAdapter(adapter);
            }
        });
        // 修改数据
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name","张三");
                cv.put("age","50");
                db.update("student",cv,"_id=1001",null);
            }
        });
        // 删除数据
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("student","_id=1002",null);
            }
        });
    }
}