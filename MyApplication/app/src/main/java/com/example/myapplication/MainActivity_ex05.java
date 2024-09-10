package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_ex05 extends AppCompatActivity {

    private int cnt = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.ClickMeBtn);
        TextView txtView = findViewById(R.id.textView);

//        final int[] cnt = {0}; // intellisense 에서 추천한 방법.. // 이런식으로도 돌아간다..
        btn.setOnClickListener(new View.OnClickListener() { // OnClickListener 객체를 익명으로 생성
            @Override
            public void onClick(View view) {
                txtView.setText("버튼을 클릭했습니다." + cnt++);
            }
        });
    }
}