package com.seunghoshin.android.adapterbasic;
// TODO 수정해야함 ! 강사님꺼보고 맞춰봐야

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
public class CustomListActivity extends AppCompatActivity {
  ListView listView;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView) findViewById(R.id.listView);
        // 1. 데이터
        ArrayList<Data> datas = Loader.getData();
        // 2. 아답터
        CustomAdapter adapter = new CustomAdapter(datas, this);
        // 3. 연결
        listView.setAdapter(adapter);
        }
}

class CustomAdapter extends BaseAdapter{ // BaseAdapter에 많은 기능이 들어가므로 임포트를 해줘야한다 .


    // 따라서 생성자를 만들었다
    ArrayList<Data> datas;

    Context context;
    LayoutInflater inflater;
    public CustomAdapter(ArrayList<Data> datas, Context context){
       // 요기도 같이
        this.datas = datas;
        this.context = context;

    //Context 하고 . 찍으면 쫘악 나오는데  인플레이트 서비스 가져오는거 (INF)만 치면 뜨는데 그거 눌르면 쫙 나옴
     inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { // 사용하는 데이터의 총 개수를 리턴 ...

        return datas.size();
    }


    @Override
    public Object getItem(int position) { // 데이터 클래스 하나를 리턴
        Log.e("Adapter","getItem position="+position);
        return datas.get(position);

    }

    @Override
    public long getItemId(int position) { // 대부분 인덱스가 그대로 리턴된다
        Log.e("Adapter","getItem[Id] position="+position);
        return position;
    }

    @Override
    // new 를 하게되면 1천개넘으면 팅겨서 convertView를 쓰는것이다. / view의 재사용성을 위해서다
    // view의 재사용성을 할때 밑으로 내리면 위에꺼 껍데기를 다시 써서 위치만 아래로 보낸다 .
    public View getView(int position, View convertView, ViewGroup parent) { // 아이템 뷰 하나를 리턴

        // xml을 class로 변환한다 .
        Log.d("ConvertView", position + "convertView" + convertView);
        //TODO 홀더
        Holder holder;
        if (convertView == null){
            holder = new Holder(); // id 랑 타이틀을 정해놓은 그릇을 만들고 그 내부값을 세팅해주는것
            // 마지막꺼 항상 null 이라고 생각하면된다 . 많이 쓰이지 않는다. 익스펜더블 리스트뷰에서 쓰인다 .
            // (R.layout.item_custom_list , parent , true)  이게 리스트에서 하나 클릭하면 쭈욱 상세 로 내려오는 뷰
            convertView = inflater.inflate(R.layout.item_custon_list, null);

        // 아래 변수 no ,title 를 재사용하기위해서 holder을 쓴다
            // , 메모리를 절약하기 위해 사ㅜ용다 . 여기다가 holder을 달면 리사이클러뷰랑 흡사하다 . 하지만 리사이클러뷰가 더 안정적
//        TextView no = (TextView) convertView.findViewById(R.id.txtNo);
//        TextView title = (TextView) convertView.findViewById(R.id.txtTitle);



        holder.no = (TextView) convertView.findViewById(R.id.txtNo);
        holder.title = (TextView) convertView.findViewById(R.id.txtTitle);
        convertView.setTag(holder);

    }else{
        holder = (Holder) convertView.getTag();
    }
        //매줄에 해당하는 데이터를 꺼낸다
        Data data = datas.get(position);
        holder.no.setText(data.getId()+"");   //getId() 가 인트값이므로 "" 를 붙여줘서 string으로 만든다.
        holder.title.setText(data.getTitle());

        return convertView;

    } //BaseAdapter의 기본이 되는 기능이 정의되어있다


class Holder{

    public TextView no;
    public TextView title;
}


}


class Loader{
    public static ArrayList<Data> getData(){
        ArrayList<Data> result = new ArrayList<>();
        for(int i=0; i<100; i++){
            Data data = new Data();
            data.setId(i+1);
            data.setTitle("타이틀"+i);
            result.add(data);
        }
        return result;
    }

}

class Data{   //int string 을 같이 넣기 위해서 클래스 하나를 생성
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}