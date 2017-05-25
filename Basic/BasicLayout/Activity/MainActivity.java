package com.seunghoshin.android.basiclayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        //1. 위젯 변수를 선언

    Button btnRelative, btnLinear, btnGrid, btnSpinner;

// TODO 를 이용하면 항상 커밋할때도 물어보고 이렇게 눈에 잘띄어서 좋다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2.

        btnRelative = (Button) findViewById(R.id.btnRelative);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnSpinner = (Button) findViewById(R.id.btnSpinner);

        btnRelative.setOnClickListener(this);
        btnLinear.setOnClickListener(this);
        btnGrid.setOnClickListener(this);
        btnSpinner.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRelative:
                Intent intent = new Intent(this, RelativeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLinear:
                Intent intent1 = new Intent(this, LinearActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnGrid:
                Intent intent2 = new Intent(this, GridActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnSpinner:
                break;
        }
    }
}
