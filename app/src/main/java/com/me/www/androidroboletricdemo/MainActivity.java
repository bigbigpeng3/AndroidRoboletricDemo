package com.me.www.androidroboletricdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity....onCreate");
        btnToSecond = (Button) findViewById(R.id.btn_toSecond);

        btnToSecond.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String srt = "";
        if (extras != null) {
            srt = (String) extras.get("activity_extra");
        }
        if (!TextUtils.isEmpty(srt)) {
            System.out.println("String srt = " + srt);
        }


    }

    @Override
    public void onClick(View v) {

        if (v == btnToSecond) {
//            Intent intent = new Intent(this,ThirdActivity.class);//如果是这条语句，Robolectric会报错
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity....onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity....onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity....onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity....onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity....onDestroy");
    }
}

