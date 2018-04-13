package com.coco3g.socketandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.coco3g.socketandroid.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        button1 = findViewById(R.id.btn_main_1);


        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_main_1:  //FullscreenActivity
                intent = new Intent(this, FullscreenActivity.class);
                startActivity(intent);

                break;
        }
    }

}
