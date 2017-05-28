package com.seunghoshin.android.activitylifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.seunghoshin.android.activitylifecycle.R.id.txtnormal;

public class GeneralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        findViewById(txtnormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 강사님이 한거 getText 보기
                String url = "naver.com";
                Uri uri = Uri.parse("http://"+url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
