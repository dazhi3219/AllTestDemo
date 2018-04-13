package com.coco3g.socketandroid.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.coco3g.socketandroid.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    //设置全屏模式(包括隐藏底部虚拟导航)
    public void setFullScreen() {
        int tag = View.SYSTEM_UI_FLAG_LOW_PROFILE |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;


//        View rootView = findViewById(android.R.id.content);
        getWindow().getDecorView().setSystemUiVisibility(tag);
        //
//        getSupportActionBar().hide();
    }


    //设置全屏模式(底部虚拟导航可见)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setFullScreen1() {
        int tag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//        View rootView = findViewById(android.R.id.content);
        getWindow().getDecorView().setSystemUiVisibility(tag);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
//        getWindow().getDecorView().setSystemUiVisibility(tag);
        //
    }


//    setSystemUiVisibility(int visibility)方法可传入的实参为：
//
//            1. View.SYSTEM_UI_FLAG_VISIBLE：显示状态栏，Activity不全屏显示(恢复到有状态栏的正常情况)。
//
//            2. View.INVISIBLE：隐藏状态栏，同时Activity会伸展全屏显示。
//
//            3. View.SYSTEM_UI_FLAG_FULLSCREEN：Activity全屏显示，且状态栏被隐藏覆盖掉。
//
//            4. View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住。
//
//            5. View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION：效果同View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//
//    6. View.SYSTEM_UI_LAYOUT_FLAGS：效果同View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//
//    7. View.SYSTEM_UI_FLAG_HIDE_NAVIGATION：隐藏虚拟按键(导航栏)。有些手机会用虚拟按键来代替物理按键。
//
//            8. View.SYSTEM_UI_FLAG_LOW_PROFILE：状态栏显示处于低能显示状态(low profile模式)，状态栏上一些图标显示会被隐藏。

    //9.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR:  状态栏颜色变黑色
//
//            4.4新特性
//
//    View.SYSTEM_UI_FLAG_IMMERSIVE  ：
//    隐藏状态栏和虚拟按键，但是滑动会弹出
//
//    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY：
//    实现全屏沉浸模式，并且隐藏顶部状态栏和底部的虚拟导航键，与上面不同的是此时通过顶部下滑会显示出透明的状态栏和虚拟导航栏，在一段时间以后自动回复成全屏沉浸模式，需要手动清除这三个标志回复原状。


}
