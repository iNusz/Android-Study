package com.seunghoshin.android.adapterbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> datas = new ArrayList<>();
    // 여기 윗부분은 초기화는 가능한데 로직이 들어가고 계산은 안된다 .


    // 다른 액티비티와 데이터를 주고받을때 사용하는 키를 먼저 정의해둔다.
    public static final String DATA_KEY = "ListActivityData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);
        //1 데이터
        for(int i=0; i<100 ; i++){
            datas.add("데이터"+i);
        }
        //2 아답터

        //context , 추상클래스라고 보면됨 . 여러가지 기능을 쓰기위해 정의를 해논거다. 기능과 속성의 모음
        //this는 특정 지을수 없기 때문에 포괄적으로 쓴다
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datas);
        //3 뷰 > 연결 > 아답터
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Activity 에 값 전달하기
                // 1. 전달받을 목적지 Intent 생성
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                // 2. putExtra 로 값 입력
                String result = datas.get(position);
                // 3. intent 를 이용한 Activity 생성 요청
                intent.putExtra(DATA_KEY, result);
                startActivity(intent);
            }
        });
    }
}
