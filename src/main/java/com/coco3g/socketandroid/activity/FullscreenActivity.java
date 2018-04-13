package com.coco3g.socketandroid.activity;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.coco3g.socketandroid.R;

public class FullscreenActivity extends BaseActivity {

    private RelativeLayout mRelativeRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fullscreen2);

        mRelativeRoot = findViewById(R.id.relative_fullscreen_root);
    }


    //底部虚拟导航不可见
    public void allFullscreen(View view) {
        RadioButton radioButton = (RadioButton) view;

        //底部虚拟导航不可见
        if (radioButton.isChecked()) {
            setFullScreen();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void Fullscreen(View view) {
        RadioButton radioButton = (RadioButton) view;

        if (radioButton.isChecked()) {
            setFullScreen1();
        }
    }


//    //设置全屏模式(包括隐藏底部虚拟导航)
//    public void setFullScreen() {
//        int tag = View.SYSTEM_UI_FLAG_LOW_PROFILE |
//                View.SYSTEM_UI_FLAG_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
//                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
//
//
//        mRelativeRoot.setSystemUiVisibility(tag);
//        //
////        getSupportActionBar().hide();
//    }
//
//
//    //设置全屏模式(底部虚拟导航可见)
//    public void setFullScreen1() {
//        int tag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
//        mRelativeRoot.setSystemUiVisibility(tag);
////        getWindow().getDecorView().setSystemUiVisibility(tag);
//        //
//    }


}
