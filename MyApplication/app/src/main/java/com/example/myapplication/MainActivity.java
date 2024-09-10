package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.ClickMeBtn);
        TextView txtView = findViewById(R.id.textView);

//        final int[] cnt = {0}; // intellisense 에서 추천한 방법.. // 이런식으로도 돌아간다..
        // 강의 안에도 있는 내용 // final 선언으로
        btn.setOnClickListener(new View.OnClickListener() { // OnClickListener 객체를 익명으로 생성
            @Override
            public void onClick(View view) {
                if(view.getAlpha() == 0.5F) {
                    view.setAlpha(1.0F);
                    btn.setText("클릭하세요!");
                    txtView.setText("버튼을 클릭했습니다." + cnt++);
                } else {
                    view.setAlpha(0.5F);
                    btn.setText("다시 클릭하세요!");
                    txtView.setText("버튼을 클릭되었습니다." + cnt++);
                }
            }
        });
    }
}