package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_ex04_logcatWithBtn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.ClickMeBtn);


        btn.setOnClickListener(new View.OnClickListener() { // OnClickListener 객체를 익명으로 생성
            @Override
            public void onClick(View view) {
                // Run에 출력
                System.out.println("ClickMeBtn 클릭! 이것은 Run에 출력");

                // Logcat에 출력 // 태그는 보통 클래스의 이름 사용...
                Log.i("MainActivity", ">>>>>>> Hello Android - Logcat에 출력 Log.i");
                Log.v("MainActivity", ">>>>>>> Hello Android - Logcat에 출력 Log.v");
                Log.w("MainActivity", ">>>>>>> Hello Android - Logcat에 출력 Log.w");
                Log.e("MainActivity", ">>>>>>> Hello Android - Logcat에 출력 Log.e");
                Log.d("MainActivity", ">>>>>>> Hello Android - Logcat에 출력 Log.d");
            }
        });
    }
}