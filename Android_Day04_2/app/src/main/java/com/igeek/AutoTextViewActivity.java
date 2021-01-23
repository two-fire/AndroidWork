package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text_view);

        String[] data = {"abcd", "jack", "rose"};
        // 适配器
        ArrayAdapter aa = new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, // 提供的纯文本框下拉列表格式
                data);
        // 单行文本自动输入
        AutoCompleteTextView act = findViewById(R.id.autoCompleteTextView);
        act.setAdapter(aa);

        // 多行文本自动输入
        MultiAutoCompleteTextView ma = findViewById(R.id.multiAutoCompleteTextView);
        ma.setAdapter(aa);
        ma.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}