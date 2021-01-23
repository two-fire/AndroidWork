package com.igeek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        // tv上注册上下文菜单
        registerForContextMenu(tv);
    }

    /**
     * 选项菜单
      */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //      菜单组号110 菜单项编号11  排第一个     名称
        menu.add(110,11,1,"开始游戏");
        menu.add(110,22,2,"暂停游戏");
        // 父菜单
        SubMenu sm = menu.addSubMenu(110, 33,
                3, "退出游戏");
        // 子菜单
        sm.add(112, 44, 1, "确定");
        sm.add(112, 55, 2, "取消");
        return super.onCreateOptionsMenu(menu);
    }

    // 监听事件 选中菜单项触发事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 11) {
            tv.setText("开始游戏");
        } else if (item.getItemId() == 22) {
            tv.setText("暂停游戏");
        }else if (item.getItemId() == 33) {
            tv.setText("退出游戏");
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 上下文菜单  长按弹窗
     *      添加在按钮 图片 文本 均可
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // 是否选中tv
        if (v == tv) {
            menu.setHeaderTitle("选择一种颜色：");
            menu.add(119,1,1,"橘色");
            menu.add(119,2,2,"紫色");
        }
    }
    // 监听事件
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 1) {
            tv.setText("橘色");
        } else if (item.getItemId() == 2) {
            tv.setText("紫色");
        }
        return super.onContextItemSelected(item);
    }
}