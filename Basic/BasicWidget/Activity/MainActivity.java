package com.seunghoshin.android.basicwidget;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener {

    // 1.  위젯 변수를 선언
    Button btndog, btnpig, btnhorse;
    ToggleButton toggleButton;
    RadioGroup radioGroup;
    SeekBar seekBar;
    TextView seekCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 위젯변수를 화면과 연결
        btndog = (Button) findViewById(R.id.btndog);
        btnpig = (Button) findViewById(R.id.btnpig);
        btnhorse = (Button) findViewById(R.id.btnHorse);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekCount = (TextView) findViewById(R.id.seekCount);

        //3. 클릭 리스너 연결

        btndog.setOnClickListener(this); // this 가 무엇을 나타내지 ? = View.OnclickListner 타입의 어떤 값
        btnpig.setOnClickListener(this); // 리스너에 this(뭔가)를 넘겨주면 해당 이벤트가 발생시
        btnhorse.setOnClickListener(this); // this(뭔가를 호출해준다 . this에 함수를 호출해준다 onclicklistner로 구현한 애만 받을수 있다

        toggleButton.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        seekBar.setOnSeekBarChangeListener(listener); //이쪽에 listener을 대입하면 아래쪽에 있는 메소드를 호출해준다
    }

    @Override
    public void onClick(View v) { // 시스템의 이벤트 리스너를 통해 호출된다. v에 클릭된 위젯수가 넘어옴 View는 {위젯 레이아웃의 최상위 클래스
        // , 뭐가넘어올지몰라서 최상위 클래스를 쓰는거임. 뷰에서 id값을 꺼낼수 있다.
        switch (v.getId()) {
            case R.id.btndog:
                Toast.makeText(this, "멍멍~", Toast.LENGTH_SHORT).show(); //short 4초 , long 8초 출력값
                break;
            case R.id.btnpig:
                Toast.makeText(this, "꿀꿀~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnHorse:
                Toast.makeText(this, "이힝~", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.toggleButton:
                if (isChecked) {
                    Toast.makeText(this, "스위치가 켜졌습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "스위치가 꺼졌습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        if (group.getId() == R.id.radioGroup) {
//        switch(group.getId()){
//            case R.id.radioGroup:
            switch (checkedId) {
                case R.id.radioRed:
                    Toast.makeText(this, "빨간불~", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioBlue:
                    Toast.makeText(this, "파란불~", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioGreen:
                    Toast.makeText(this, "초록불~", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekCount.setText(progress + " ");    // ""를 넣는 이유가 int값이나오면 오류가 생기니 ""를 붙인다
            // setText가 받을수 있는게 string 밖에 안되서 int들어있는걸 "" 더해서 string으로 바궈야된다
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            //
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //
        }

    };
}

