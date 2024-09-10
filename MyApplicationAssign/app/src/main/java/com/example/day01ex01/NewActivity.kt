package com.example.day01ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication_assign.R

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val genderTxtView : TextView = findViewById<TextView>(R.id.gender);
        val nameTxtView : TextView = findViewById(R.id.name);

        genderTxtView.setText(getIntent().getStringExtra("radioBtnVal"));
        nameTxtView.setText(getIntent().getStringExtra("inputTxtVal"));

        val backBtn : Button = findViewById<Button>(R.id.backBtn);
        backBtn.setOnClickListener(
            View.OnClickListener {
                onBackPressed();
                finish();
            }
         )
    }


}