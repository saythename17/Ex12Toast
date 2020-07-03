package com.icandothisallday2020.ex12toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //onClick 속성이 부여된 View 클릭시 자동으로 실행되는 메소드
    public void isakToast(View v){
        //1. Create Toast class
        // [*new* 대신->Toast class's method *make Text*]
        Toast toast= Toast.makeText(this,"click",Toast.LENGTH_SHORT);
        //                  └static method                         └final static
        //parameter:**Context : 안드로이드 운영체제의 기능을
        //                      사용할 수 있는 class
        // 운영체제의 대리인-하드웨어 제어,
        //App work with--Operating System : Android ,ios ...
        //But.. 앱이직접 운영체제를 건드리면 위험하니까
        //Context 에게 화면 띄워줘! 와이파이! 블루투스! 요청
        //  └각 앱마다 파견된 대리인
        //운영체제의 대리인, 위임장을 받은 녀석=Context
        //모든 View 는 Context 와 연결되어 있음
        //Activity already extended Context 상속관계
        //∴Context 의 능력을 가진 Activity 를 줘도됨
        //          **하드코딩 text or res-string reference,
        //          **duration(time) 0:short/1:long
        //*show assistance : ctrl+P
        //만들어진 Toast 객체 화면에 보이기

        //2. res/values/string.xml 에 문자열을 만들고
        //   Toast 에서 문자열을 읽어와 보여주기
        toast=Toast.makeText(this,R.string.toast_text,Toast.LENGTH_SHORT);
        //                                      └ctrl +/ctrl -저장된 문자열 보여줌
        //3. Set Toast's position
        toast.setGravity(Gravity.CENTER,0,-400);
        //Offset 편차| xOffset: 100 = 100px 오른쪽으로 | xOffset: -100 :왼쪽으로
        //yOffset: +100: 밑으로 내려갈수록 값이 커짐 | -100: 100px 위로
        //toast.show();

        //3. Toast 에 문자열이 아닌 원하는 모양의 View 띄우기
        toast=Toast.makeText(this,"",Toast.LENGTH_LONG);
        //두번째 파라미터가 필요없는 상황
        //Toast 가 보여줄 View 설정 [default : TextView]
        //이미지 뷰 객체 생성
        ImageView image=new ImageView(this);
        image.setImageResource(android.R.drawable.ic_lock_silent_mode);
        //android.R 운영체제의 리소스를 가져다 쓸때
        //텍스트 뷰 객체 생성
        TextView text=new TextView(this);
        text.setText("Be quite!");
        //토스트는 하나의 뷰만 설정가능
        //ViewGroup 을 만들어서 그 안에 View 를 넣고 Toast 에 ViewGroup 을 설정
        LinearLayout layout= new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);//v:1 h:0
        layout.addView(image);
        layout.addView(text);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER,0,-500);
        //toast.show();

        //4. xml 로 View 객체의 모양을 설계하고, 이를 객체로 만들어 사용
        //layout folder 안 (View 가 배치된)xml 문서를 만들기
        toast=Toast.makeText(this,"",Toast.LENGTH_LONG);
        //toast.xml 에 설계된 뷰들을 자바의 View 객체로 만들기
        //LayoutInflater(운영체제 안 이미존재) 에게 객체로 만들어 달라고 요청
        LayoutInflater inflater=this.getLayoutInflater();//this:MainActivity
        View view=inflater.inflate(R.layout.toast,null);
        toast.setView(view);//<-Parameter : View 이기 때문
        toast.setGravity(Gravity.CENTER,0,-500);
        toast.show();
    }
}
/*xml 을 parsing 해야 java 와 연결/parseInt/parse:분석하다
*xml is just memo program
* xml 문서---setContentView():무지개로드 생성 메소드---java 문서
*             └InputStream--BufferedReader
*View 설계---new! View---View class
*             └View 객체로 만들어줌(생성- Inflate 부풀리다)
*마치 종이 설계도를 풍선을 불듯 부풀려서 생성!
*객체로 생성해주는 녀석 LayoutInflater*/
