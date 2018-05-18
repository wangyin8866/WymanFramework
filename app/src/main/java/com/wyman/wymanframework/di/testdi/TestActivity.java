package com.wyman.wymanframework.di.testdi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wyman.wymanframework.R;

import javax.inject.Inject;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */

public class TestActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Inject
    Student student1;
    @Inject
    Student student2;

    @Inject
    BaseApplication application;
    @Inject
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        textView = findViewById(R.id.tv1);
        button = findViewById(R.id.btn1);
        DaggerTestComponent.builder().baseApplicationComponent(DaggerBaseApplicationComponent.builder().baseApplicationModule(new BaseApplicationModule(BaseApplication.application)).build())
                .build().inject(this);
        textView.setText(application.toString()+"\n"+context.toString()+"\n"+BaseApplication.application.toString()+"=="+BaseApplication.mContext.toString());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TestActivity.this, Test2Activity.class));
            }
        });


    }
}
