package com.seunghoshin.android.adapterbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    // 아답터를 쓰는 이유가 데이터가 변경되도 아답터만 변경하면 되기 떄문에 좋다 .
    // 리스트 = 곧 아답터다 . 아답터를 조작해서 한다
    String datas[] = {"선택하세요","ListView","CustomList", "GridView", "RecyclerView"};
    final int LIST = 1;
    final int CUSTOM = 2;
    final int GRID = 3;
    final int RECYCLER = 4;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);

        // List 뷰에 데이터를 연결하기
        // 1. 데이터 정의
        // dats 정의함

        // 2. 아답터 생성
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datas);
        // 3. 뷰에 아답터 연결
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("SpinnerValue",datas[position]+". id="+id);
                // id는 순서대로 눈에 보이는 id의 값 , 이게 다를경우가있는데 그건 목록을 숨겼거나 하면 달라진다


                // 안쪽에다가 중복선언을 못하기 때문에 밖에서 선언했다
                Intent intent;
                switch (position){
                    case LIST:
                        // this 는 원래 나를 감싸고있는 곳에 변수를 뜻한다
                        intent = new Intent(MainActivity.this, ListActivity.class);
                        startActivity(intent);
                        break;
                    case GRID:
                        // 안쪽에  intent 를 중복해서 선언할수없다  . 따라서 밖에다가 선언해야한다
                        intent = new Intent(MainActivity.this, GridActivity.class);
                        startActivity(intent);
                        break;
                    case RECYCLER:
                        intent = new Intent(MainActivity.this, RecyclerActivity.class);
                        startActivity(intent);
                        break;
                    case CUSTOM:
                        intent = new Intent(MainActivity.this, CustomListActivity.class);
                        startActivity(intent);
                    default: // 선택하세요

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
