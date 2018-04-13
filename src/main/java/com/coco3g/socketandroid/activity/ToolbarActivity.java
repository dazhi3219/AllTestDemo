package com.coco3g.socketandroid.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.coco3g.socketandroid.R;
import com.coco3g.socketandroid.utils.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ToolbarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView mImage, mImageDownload;
    private LinearLayoutCompat mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        mImage = findViewById(R.id.image_toolbar);
        mImageDownload = findViewById(R.id.image_download);
        mLinearLayout = findViewById(R.id.linear_root_view);

        testdemo();
    }

    private void testdemo() {

        String path1 = getFilesDir().getAbsolutePath();
        String path2 = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();

        Log.e("路径", path1);
        Log.e("路径", path2);

//        ObjectInputStream objectInputStream = new ObjectInputStream


    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void downPic(View view) {
        Intent intent = new Intent(this, FullscreenActivity1.class);
        startActivity(intent);


//        Glide.with(this).asBitmap().load(Data.ImageUrl).into(new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
//                savaPic(resource);
//
//
//            }
//        });
//        Observable.create(new Observable.OnSubscribe<String>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                downloadPic();
//                subscriber.onNext("dazhiceshi.png");
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Glide.with(ToolbarActivity.this).load(new File(getExternalFilesDir(""), "111.png")).
//                        into(mImageDownload);
//            }
//        });

    }

    //网络下载图片
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void downloadPic() {

        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL(Data.ImageUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.setDoOutput(true);
            //连接
            httpURLConnection.connect();

            //获取请求码
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();

                Log.e("下载文件类型", httpURLConnection.getContentType());
//                httpURLConnection.getContentType().startsWith("com");

                //
//                File file = new File(getExternalFilesDir(""), "dazhiceshi.png");
                File file = new File(getExternalFilesDir(""), "111.png");
                if (!file.exists() || !file.isFile()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);

                byte[] bytes = new byte[1024];
                int num = -1;
                while ((num = inputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, num);
                    fileOutputStream.flush();
                }

            } else {
                Log.e("下载文件出错", httpURLConnection.getResponseMessage() + "  code;" + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //保存图片
    public void savaPic(Bitmap bitmap) {
        File file = new File(getExternalFilesDir(""), "ceshi.png");
        if (file.exists()) {
            file.delete();
            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void setContentType() {
        File file = new File("ceshi.txt");


    }


    //展示图片
    public void showPic(View view) {
        File file = new File(getExternalFilesDir(""), "ceshi.png");
        if (!file.exists()) {
            System.out.println("图片目录不存在");
        } else {
            Glide.with(this).load(file).into(mImage);
        }

    }


    //第六空间
    public void changeType1(View view) {
        mLinearLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    //第六空间
    public void changeType2(View view) {
        mLinearLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    //第六空间
    public void changeType3(View view) {
        mLinearLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    //第六空间
    public void changeType4(View view) {
        mLinearLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
