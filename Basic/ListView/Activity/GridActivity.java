package com.seunghoshin.android.adapterbasic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        // 1 . 데이터
        ArrayList<Data> datas = Loader.getData(); // new ArrayList<>();  // 이렇게 뜨면 new ArrayList<>()가 쓸모가 없다 .
        // datas = Loader.getData(); // 위에꺼랑 합쳐진거

        // 2 . 아답터
        GridAdapter adapter = new GridAdapter(datas, this);

        //3. 연결
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

    }
}

class GridAdapter extends BaseAdapter {


    ArrayList<Data> datas;

    Context context;
    LayoutInflater inflater;

    public GridAdapter(ArrayList<Data> datas, Context context) {

        this.datas = datas;
        this.context = context;


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // 사용하는 데이터의 총 개수를 리턴 ...

        return datas.size();
    }


    @Override
    public Object getItem(int position) { // 데이터 클래스 하나를 리턴
        Log.e("Adapter", "getItem position=" + position);
        return datas.get(position);

    }

    @Override
    public long getItemId(int position) { // 대부분 인덱스가 그대로 리턴된다
        Log.e("Adapter", "getItem[Id] position=" + position);
        return position;
    }

    @Override
// new 를 하게되면 1천개넘으면 팅겨서 convertView를 쓰는것이다. / view의 재사용성을 위해서다
// view의 재사용성을 할때 밑으로 내리면 위에꺼 껍데기를 다시 써서 위치만 아래로 보낸다 .
    public View getView(int position, View convertView, ViewGroup parent) { // 아이템 뷰 하나를 리턴

        // xml을 class로 변환한다 .
        Log.d("ConvertView", position + "convertView" + convertView);

        Holder holder;
        if (convertView == null) {
            holder = new Holder(); // id 랑 타이틀을 정해놓은 그릇을 만들고 그 내부값을 세팅해주는것
            // 마지막꺼 항상 null 이라고 생각하면된다 . 많이 쓰이지 않는다. 익스펜더블 리스트뷰에서 쓰인다 .
            // (R.layout.item_custom_list , parent , true)  이게 리스트에서 하나 클릭하면 쭈욱 상세 로 내려오는 뷰
            convertView = inflater.inflate(R.layout.item_custom_grid, null);

            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            holder.title = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }
        //매줄에 해당하는 데이터를 꺼낸다
        Data data = datas.get(position);


        // 이미지 세팅하기
        // 1. 이미지 suffix 만들기
        int suffix = (data.getId()%5) + 1; // 이미지가 5개이기 때문에

                                                    //리소스아이디
        // 2. 문자열로 리소스 아이디 가져오기                                //리소스패키지
        int id = context.getResources().getIdentifier("twice"+suffix,"mipmap", context.getPackageName());

        // 3. 리소스 아이디를 이미지뷰에 세팅하기
        holder.image.setImageResource(id);

        holder.title.setText(data.getTitle());

        return convertView;

    }

    // Holder는 item layout에 있는 위젯을 정의해둔다 .
    class Holder{

        public ImageView image;
        public TextView title;
    }

}




