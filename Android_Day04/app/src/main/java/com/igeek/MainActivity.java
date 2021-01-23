package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 开关 开启关闭
        ToggleButton tb  = findViewById(R.id.toggleButton);
        tv = findViewById(R.id.tv);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                tv.setText(b?"开启":"关闭");
            }
        });

        // 单选框 男女
        tv2 = findViewById(R.id.tv2);

        RadioGroup rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                tv2.setText(i == R.id.radioButton2 ? "女" : "男");
            }
        });

        // 复选框
        tv3 = findViewById(R.id.tv3);
        CheckBox cb1 = findViewById(R.id.checkBox1);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    tv3.append(compoundButton.getText() + " ");
                }
            }
        });
        CheckBox cb2 = findViewById(R.id.checkBox2);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    tv3.append(compoundButton.getText() + " ");
                }
            }
        });
        CheckBox cb3 = findViewById(R.id.checkBox3);
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    tv3.append(compoundButton.getText() + " ");
                }
            }
        });

    // 补间动画


    }
}