package com.seunghoshin.android.intentbasic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtCall, txtUrl;
    Button btnCall, btnBrowser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCall = (EditText) findViewById(R.id.txtcall);
        btnCall = (Button) findViewById(R.id.btncall);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtCall.getText().toString();
                Uri uri = Uri.parse("tel:"+phoneNumber); // 프로토콜 : https
                // parse 는 String (데이터를) 객체화 시키면 된다. <-> to.string
                //Uri 는 안들아드에서 쓰는 것이다 플래그값 정해져있는상숙삽

                //uri : 내시스템 자원 사용 / 음악파일,사진,웹주소 등등 자원들의 유일한 값 / 안드로이드를 가리키기위한 주소 체계이다..
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });
        txtUrl = (EditText) findViewById(R.id.txtUrl);
        btnBrowser = (Button) findViewById(R.id.btnBrowser);
        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = txtUrl.getText().toString();
                Uri uri = Uri.parse("http://"+url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }



}
