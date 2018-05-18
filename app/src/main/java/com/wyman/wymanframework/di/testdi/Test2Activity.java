package com.wyman.wymanframework.di.testdi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wyman.wymanframework.R;

import javax.inject.Inject;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */

public class Test2Activity extends AppCompatActivity {
    private TextView textView;
    @Inject
    Student student;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        textView = findViewById(R.id.tv2);
        DaggerTest2Component.builder().build().inject(this);
        textView.setText(student.toString());
    }
}
