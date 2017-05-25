package com.seunghoshin.android.customlistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.seunghoshin.android.customlistview.MainActivity.DATA_KEY;
import static com.seunghoshin.android.customlistview.MainActivity.DATA_RES_ID;
import static com.seunghoshin.android.customlistview.MainActivity.DATA_TITLE;

public class MainActivity extends AppCompatActivity {


    public static final String DATA_KEY = "position";
    public static final String DATA_RES_ID = "resid";
    public static final String DATA_TITLE = "title";

    ArrayList<Data> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 두 화면의 데이터를 가져오는 기능 / 컨트롤러 (C)

        // 1. 데이터
        datas = Loader.getData(this);

        // 2. 아답터
        CustomAdapter adapter = new CustomAdapter(datas, this);

        // 3. 연결
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

//        Adapter안으로 이동

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//
//                Data data = datas.get(position);
//
//                intent.putExtra(DATA_KEY, position);
//                intent.putExtra(DATA_RES_ID, data.resId);
//                intent.putExtra(DATA_TITLE, data.title);
//
//                startActivity(intent);

//            }
//        });

    }
}

class CustomAdapter extends BaseAdapter{

    // 위의 2번 의 클래스가 이것이다.

    // 1.데이터
    ArrayList<Data> datas;

    // 2.인플레이터 ,  TODO 컨텍스트 ?
    LayoutInflater inflater;

    // 3.컨텍스트
    Context context;

    public  CustomAdapter(ArrayList<Data> datas, Context context){
        this.datas = datas;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override //TODO 방과후 수업때 한내용 !
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. 컨버터뷰를 체크해서 null일 경우만 item layout을 생성해준다

        Holder holder;
        if(convertView ==null) {
            convertView = inflater.inflate(R.layout.item_list, null);
            holder = new Holder(convertView,context); //생성자에게 넘겨준다

            convertView.setTag(holder); //setTag는 오브젝트로 들어가게 된다 .
        }else{
            // 홀드안에 있는 위젯은 컨버트뷰안에 있는 위젯과 동일하다 .
            holder = (Holder) convertView.getTag();
        }
        // 2. 내 아이템에 해당하는 데이터를 세팅해준다.
        Data data = datas.get(position);

//        ((TextView) convertView.findViewById(R.id.txtNo)).setText(data.no+"");
//        ((TextView) convertView.findViewById(R.id.txtNo)).setText(data.title);
        holder.setNo(data.no);
        holder.setTitle(data.title);
        holder.setImage(data.resId);

        // id를 가져오는 작업을 loader 에서 한다.
        // int id = context.getResources().getIdentifier("twice"+suffix,"mipmap", context.getPackageName());

        holder.image.setImageResource(data.resId);

        return convertView;
    }

    class Holder { // (View)에 해당한다
        int position;

        TextView no;
        TextView title;
        ImageView image;
        int resId;
        //생성자를 쓴다 .
        public Holder(View view,final Context context) { //지역변수이니까 참조하는 주소값이 달라져서 null 이뜬다 전역변수로 final 달아준것이다.
            no = (TextView) view.findViewById(R.id.txtNo);
            title = (TextView) view.findViewById(R.id.txtTitle);
            image = (ImageView) view.findViewById(R.id.detail);
            //1. 이미지뷰에 onClick listener를 달고 상세페이지로 이동시킨다 .
            image.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                // 이런 로직은 view에 있지 않고 presenter에 있다 .
                    Intent intent = new Intent(context, DetailActivity.class);
                //TODO this의 범위
                    intent.putExtra(DATA_KEY, Holder.this.position); // 익명개체에서 나를 품고있는 객체를 참조할때 this
                    // 왜 위에 있는 Intent가 아니냐면 {} 가 없기 때문에 나를 포함하고있지 않아서다 . 그래서 여기서는 나를포함하고있는 OnclickListener이다 .
                    // 여기서 Holder.this를 왜빼도되냐면 지역변수에 없기때문에 위로쭉쭉 올라가서 전역변수인 position을 찾아가기 때문이고
                    // 만약에 지역변수에 있으면 지역변수를 가리킨다 .
                intent.putExtra(DATA_RES_ID, resId);
                intent.putExtra(DATA_TITLE, title.getText().toString());

                context.startActivity(intent);
                }
            });
            //2. 타이틀 텍스트 뷰에 onClick Listener를 달고 Toast로 내용을 출력한다 .
            // 이런 로직은 view에 있지 않고 presenter에 있다 .
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, title.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setNo(int no){
            this.no.setText(no+"");
        }
        public void setTitle(String title){
            this.title.setText(title);
        }

        public void setImage(int resId){
            this.resId = resId;
            this.image.setImageResource(resId);
        }

    }
}


class Loader{
    public static ArrayList<Data> getData(Context context){
        ArrayList<Data> result = new ArrayList<>();

        for(int i=1; i<=10 ; i++){
            Data data = new Data();
            data.no = i;
            //TODO 보통은 이미지를 웹상에서 불러오는데 웹사이트 하나에 내가 쓸이미지를 다 넣고 쓰는 건가 ? == 내가 쓸 이미지를 웹서버에 다박아놓고 쓴다.
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