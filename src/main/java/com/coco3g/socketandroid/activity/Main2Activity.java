package com.coco3g.socketandroid.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.coco3g.socketandroid.R;

import java.util.ArrayList;

import rx.Observable;
import rx.functions.Func2;

public class Main2Activity extends AppCompatActivity {

    private TextView mTxtTest, mTxtTime;
    private ProgressBar progressBar;
    private EditText mEditText;

    private TextWatcher textWatcher;
    private Toast toast;

    private String Tag = "打印日志！！";

    private ImageView mImage;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTxtTest = findViewById(R.id.tv_test);
        mTxtTime = findViewById(R.id.tv_test_time);
        progressBar = findViewById(R.id.progressbar_main);
        mEditText = findViewById(R.id.edit_main);
        mImage = findViewById(R.id.image_main2);
        //

        final ArrayList<Student> mList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student("大治" + i, new Math("Math" + i), new English("English" + i), new Franch("Franch" + i));
            mList.add(student);
        }

        context = Main2Activity.this;

        final int[] count = {0};

        mTxtTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5);
                Observable<Integer> observable2 = Observable.just(6, 7, 8, 9, 10);

                observable1.zipWith(observable2, new Func2<Integer, Integer, String>() {
                    @Override
                    public String call(Integer integer, Integer integer2) {

                        return integer + integer2 + "";
                    }
                });
            }
        });


    }


    class Student {

        public Student(String name, Math math, English english, Franch franch) {
            this.name = name;
            this.math = math;
            this.english = english;
            this.franch = franch;
        }

        public String name = "大治";

        public Math math;

        public English english;

        public Franch franch;


        public ArrayList<Course> getAll() {
            ArrayList<Course> mList = new ArrayList<>();
            mList.add(math);
            mList.add(english);
            mList.add(franch);

            return mList;
        }

    }


    interface Course {
        String getName();
    }

    class Math implements Course {
        public String name;

        public Math(String name) {
            this.name = name;
        }

        public String id;

        @Override
        public String getName() {
            return name;
        }
    }

    class English implements Course {
        public String name;

        public English(String name) {
            this.name = name;
        }

        public String id;

        @Override
        public String getName() {
            return name;
        }
    }

    class Franch implements Course {
        public String name;

        public Franch(String name) {
            this.name = name;
        }

        public String id;

        @Override
        public String getName() {
            return name;
        }
    }


}

