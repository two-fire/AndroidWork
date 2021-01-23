package com.xample.android_day05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    SeekBar sb;
    TextView tv;
    ImageSwitcher is;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        progressBar();
//        seekBar();

//        setContentView(R.layout.view_item);

//        setContentView(R.layout.listview_show);
//        listView();

//        setContentView(R.layout.scrollview_show);

//        setContentView(R.layout.tabhost_show);
//        tabhost();

//        盖浇饭、白米饭 选择框
//        setContentView(R.layout.spinner);
//        spinner();

//        图片轮转 上一页/下一页
//        setContentView(R.layout.imageswitch_show);
//        imageswicher();

        setContentView(R.layout.grid_view);
        gridview();

    }

    void gridview() {
        GridView gv = findViewById(R.id.gridview);
        int[] imgs = {R.drawable.img, R.drawable.b, R.drawable.c,
                R.drawable.a, R.drawable.d, R.drawable.e};
        String[] names = {"美团", "百度", "饿了么",
                "知乎", "王者荣耀", "晋江"};

        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", imgs[i]);
            map.put("name", names[i]);
            list.add(map);
        }
        gv.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.gridview_item,
                new String[]{"img","name"},
                new int[]{R.id.iv, R.id.tv}));
    }

    void imageswicher(){
        final int[] imgs={R.drawable.a,R.drawable.b,R.drawable.c};
        Button bt4=findViewById(R.id.button4);
        is=findViewById(R.id.imageswitcher);
        is.setBackgroundResource(imgs[0]);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i < imgs.length -1) {
                    i++;
                    is.setBackgroundResource(imgs[i]);
                }
            }
        });
        Button bt3=findViewById(R.id.button3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 上一张
                if (i > 0) {
                    i--;
                    is.setBackgroundResource(imgs[i]);
                }
            }
        });
    }
    void tabhost(){
        TabHost th=findViewById(R.id.tabhost);
        th.setup();
        th.addTab(th.newTabSpec("1").setIndicator(null,getResources().getDrawable(R.drawable.img)).setContent(R.id.tv1));
        th.addTab(th.newTabSpec("2").setIndicator(null,getResources().getDrawable(R.drawable.img)).setContent(R.id.tv2));
        th.addTab(th.newTabSpec("3").setIndicator(null,getResources().getDrawable(R.drawable.img)).setContent(R.id.tv3));
        th.setCurrentTab(0);
    }

    void spinner(){
        List<String> list=new ArrayList<>();
        list.add("盖浇饭");
        list.add("面条");
        list.add("水饺");
        list.add("白馒头");

        ArrayAdapter aa=new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item,list);
        Spinner sp=findViewById(R.id.spinner);
        sp.setAdapter(aa);

    }

    void listView(){
        ListView lv= findViewById(R.id.listview);
        List<Map<String,Object>> list=new ArrayList<>();

        for(int i=0;i<50;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",R.drawable.img);
            map.put("name","jack"+i);
            map.put("phone","139"+i+156121345);
            list.add(map);
        }
        ListAdapter la=
                new SimpleAdapter(this,list,R.layout.view_item,
                        new String[]{"img","name","phone"},
                        new int[]{R.id.imageview,R.id.textView3,R.id.textView4});

        lv.setAdapter(la);
    }

    void seekBar() {
        sb = findViewById(R.id.seekBar);
        tv = findViewById(R.id.textView);
        RatingBar rb = findViewById(R.id.ratingBar);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv.setText("评分：" + v + "颗星星");
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // seekBar：本身  i：进度  b：判断是否是用户操作
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText("当前进度为：" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    void progressBar() {
        pb = findViewById(R.id.progressBar2);
        Button bt = findViewById(R.id.button);
        // 进度条
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        while (i <= 110) {
                            pb.setProgress(i);
                            i += new Random().nextInt(10);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        });
    }


}