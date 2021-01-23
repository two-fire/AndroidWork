package com.xample.android_studentmanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = SQLiteDatabase.openOrCreateDatabase(
                "/data/data/com.xample.android_studentmanager/student.db", null);
//        db.execSQL("create table student(_id int, name char(20),age int)");

        showStudent();
        // 修改学生信息
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 获取学生信息的布局
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.add_student,null);
                final AlertDialog dialog = builder.setTitle("修改学生信息").setView(layout).create();
                showStudent();
                final EditText et1 = layout.findViewById(R.id.et1);
                final EditText et2 = layout.findViewById(R.id.et2);
                final EditText et3 = layout.findViewById(R.id.et3);
                et1.setText(sid);
                et2.setText(sname);
                et3.setText(sage+"");
                dialog.show();
                // 为dialog弹框中按钮添加点击事件
                Button bt = dialog.getWindow().findViewById(R.id.button4);
                bt.setText("修改学生信息");
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues cv = new ContentValues();
                        cv.put("name",et2.getText().toString());
                        cv.put("age",et3.getText().toString());
                        db.update("student",cv,"_id="+sid,
                                null);
                        showStudent();
                        dialog.dismiss();
                    }
                });
            }
        });
        // 删除学生信息
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  db.delete("student","_id="+sid,null);
                  showStudent();
              }
        });
        // 新增学生信息
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // 获取新增学生信息的布局
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.add_student,null);
                final AlertDialog dialog = builder.setTitle("新增学生信息").setView(layout).create();
                dialog.show();
                showStudent();
                final EditText et1 = layout.findViewById(R.id.et1);
                final EditText et2 = layout.findViewById(R.id.et2);
                final EditText et3 = layout.findViewById(R.id.et3);
                // 为dialog弹框中按钮添加点击事件
                dialog.getWindow().findViewById(R.id.button4)
                        .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this,
//                                et2.getText().toString(),
//                                Toast.LENGTH_LONG).show();
                        db.execSQL("insert into student " +
                                "values("+et1.getText().toString()+
                                ",'" +et2.getText().toString()
                                +"',"+et3.getText().toString()+")");
                        showStudent();
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    String sid,sage,sname;
    public void showStudent() {
        Cursor cursor = db.query("student",null,null,
                null,null,null,null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this,
                R.layout.list_item,
                cursor,
                new String[]{"_id","name","age"},
                new int[]{R.id.tv1,R.id.tv2,R.id.tv3});
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);

        // 为listview添加选中事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv1 = view.findViewById(R.id.tv1);
                TextView tv2 = view.findViewById(R.id.tv2);
                TextView tv3 = view.findViewById(R.id.tv3);
                sid = tv1.getText().toString();
                sname = tv2.getText().toString();
                sage = tv3.getText().toString();

//                Toast.makeText(MainActivity.this,tv1.getText().toString(),
//                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
