package com.seunghoshin.android.recycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
// TODO 홀더에 온클릭리스너 달고 커스텀뷰와 같이 똑같이 하면 된다
    RecyclerView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (RecyclerView) findViewById(R.id.listView);

        //1.데이터
        ArrayList<Data> datas = Loader.getData(this);
        //2.아답터
        CustomRecycler adapter = new CustomRecycler(datas, this);

        //3.연결
        listview.setAdapter(adapter);

        //4.레이아웃 매니저 (뷰의 속성을 바꿔준다 ) 그리드라던가 리스트라던가
        listview.setLayoutManager(new LinearLayoutManager(this));

    }
}

class CustomRecycler extends RecyclerView.Adapter<CustomRecycler.Holder>{
    ArrayList<Data> datas;
    Context context;
    public CustomRecycler(ArrayList<Data> datas, Context context){

        this.datas = datas;
        this.context = context;
    }


    // List view 에서 convertview == null 일때 처리
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) { //홀더만드는것
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null);
        // TODO 위아래꺼 차이
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

//      Holder holder = new Holder(view);
//      return holder;
        return new Holder(view); //위에 2개합친거
    }

    // 각 데이터셀이 나타날때 호출되는 변수
    @Override
    public void onBindViewHolder(Holder holder, int position) { //홀더에 값을 설정

        //1. 데이터를 꺼내고
        Data data = datas.get(position);
        //2. 데이터를 셋팅
        holder.setImage(data.resId);
        holder.setNo(data.no);
        holder.setTitle(data.title);
    }

    // 데이터의 전체개수
    @Override
    public int getItemCount() {
        return datas.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView no;
        TextView title;

        public Holder(View itemView) {
            super(itemView); //상속을 받으면 상속받은거의 기본 생성자가 호출된다 / 기본생성자가 있고 없고의 차이 TODO 왜 super을 써야하나 ?
            image = (ImageView) itemView.findViewById(R.id.image);
            no = (TextView) itemView.findViewById(R.id.txtNo);
            title = (TextView) itemView.findViewById((R.id.txtTitle));
        }

        public void setImage(int resId){
            image.setImageResource(resId);
        }


        public void setNo(int no){
            this.no.setText(no+"");
        }

        public void setTitle(String title){
            this.title.setText(title);
        }



    }
}




class Loader{
    public static ArrayList<Data> getData(Context context){
        ArrayList<Data> result = new ArrayList<>();

        for(int i=1; i<=10 ; i++){
            Data data = new Data();
            data.no = i;
            data.title = "트와이스";
            data.setImage("twice"+i, context);
            result.add(data);
        }
        return result;
    }
}

class Data{
    // getter setter 말고 직접 접근한다 . 취직할꺼면 갯터셋터 써야한다 . 협업할때 인터페이스가 의미있다.
    public int no;
    public String title;
    public String image;
    public int resId;

    public void setImage(String str, Context context){
        image = str;
        //문자열로 리소스 아이디 가져오기
        resId = context.getResources().getIdentifier(image,"mipmap", context.getPackageName());
    }

}