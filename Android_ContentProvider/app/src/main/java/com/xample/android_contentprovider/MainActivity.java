package com.xample.android_contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 一定要先插入一条空数据，会返回rowContractid
                ContentValues values = new ContentValues();
                Uri uri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI,
                        values);
                long rawContractId = ContentUris.parseId(uri);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContractId);
                // 设置内容类型
                values.put(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                // 设置联系人姓名
                values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,
                        et1.getText().toString());
                // 插入联系人姓名
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContractId);

                // 设置内容类型
                values.put(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                // 设置联系人手机
                values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, et2.getText().toString());

                // 设置电话号码类型
                values.put(ContactsContract.CommonDataKinds.Phone.TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
//                插入联系人手机
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取联系人信息
                Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, null,null,null);
                List<PhoneDto> list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    // 获取联系人姓名
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    // 获取联系人手机
                    String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    System.out.println("---姓名--"+name+"---手机---"+phone);
                    PhoneDto dto = new PhoneDto();
                    dto.setName(name);
                    dto.setPhone(phone);
                    list.add(dto);
                }
                ListView listView = findViewById(R.id.listView);
                MyAdapter adapter = new MyAdapter(list, MainActivity.this);
                listView.setAdapter(adapter);
            }
        });
    }
}