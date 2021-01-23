package com.xample.android_contentprovider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<PhoneDto> list;
    Context context;
    public MyAdapter(List<PhoneDto> li, Context con) {
        list = li;
        context = con;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PhoneDto phoneDto = list.get(i);
        LinearLayout linearLayout = new LinearLayout(context);
        // 必须指定的两种属性。宽度没指定，高度包裹内容
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        // 姓名
        TextView tv1 = new TextView(context);
        tv1.setId(View.generateViewId());
        tv1.setLayoutParams(params);
        tv1.setText(phoneDto.getName());
        // 手机
        TextView tv2 = new TextView(context);
        tv2.setId(View.generateViewId());
        tv2.setLayoutParams(params);
        tv2.setText(phoneDto.getPhone());

        linearLayout.addView(tv1);
        linearLayout.addView(tv2);
        return linearLayout;
    }
}
