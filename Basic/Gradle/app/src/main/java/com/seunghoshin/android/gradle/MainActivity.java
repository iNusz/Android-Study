package com.seunghoshin.android.gradle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 그래들을 이용해서 MYURL로 바로 들어갈수 있다
        ((TextView) findViewById(R.id.textView)).setText(BuildConfig.MYURL);

    }
}
