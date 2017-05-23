package com.seunghoshin.android.adapterbasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 자바에서 치면 new 랑 동일하다.
        textView = (TextView) findViewById(R.id.textView);



        // Activity 에서 넘어온 값 저장하기
        //1. intent 꺼낸다  TODO 아래꺼랑 , / 번들 , 인텐트 , 겟엑스트라 의 관계 그림으로 된거 다시 물어보기
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();  // 데이터의 모음
        //2. bundle 안에 아무것도 안넣으면 null값을 가져오므로 초기화를 시켜줌
        String result = "";

        //3. bundle이 있는지 유효성 검사를 한다
        if(bundle != null)
            //3.1 bundle 이 있으면 값을 꺼내서 변수를 얻는다 (여러개나 한개있어도 넣어줌 )
            result = bundle.getString(ListActivity.DATA_KEY);


        textView.setText(result);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 따라서 finish 를 쓴다
//                Intent intent = new Intent(DetailActivity.this, ListActivity.class);
//                startActivity(intent); // 스택이 계속 쌓인다 / activity는 스택 구조이다
            }
        });


    }
}
