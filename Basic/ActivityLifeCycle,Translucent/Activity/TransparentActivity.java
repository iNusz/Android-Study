package com.seunghoshin.android.activitylifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TransparentActivity extends AppCompatActivity {

    TextView txttrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);

        txttrans = (TextView) findViewById(R.id.txttrans);

        txttrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=출발지주소&daddr=도착지주소&hl=ko");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);


            }
        });


    }


}
