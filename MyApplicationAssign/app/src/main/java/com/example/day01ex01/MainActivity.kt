package com.example.day01ex01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_assign.R

class MainActivity : AppCompatActivity() {
    final val cnt : IntArray = IntArray(1);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hello2Txt = findViewById<TextView>(R.id.hello2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val editText = findViewById<EditText>(R.id.editText)

//        AppCompatEditText



        // 출처 : https://velog.io/@kbs95123/Android-Java-백버튼을-눌러서-EditText포커스-해제하기
        /**
         * 실제로 아래 이벤트는 출처의 설명과 다르게 동작은 하지만
         */
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action === KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                    editText.clearFocus()
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0)
                    return@OnKeyListener true
                }
            }
            false
        })
        editText.setOnFocusChangeListener { view, hasFocus ->
            Log.i("MainActivity",">>>>>>>> ${view} ${hasFocus}");
            if(!hasFocus) {
                editText.clearFocus();
                imm.hideSoftInputFromWindow(view.windowToken, 0)
//                editText.focusㅁㄴ
            }
        }


        // Javascript의 getElementById()와 유사하다.
        val clickMeBtn = findViewById<Button>(R.id.clickMeBtn)
        clickMeBtn.setOnClickListener {
            hello2Txt.text = "Ok버튼 클릭 함!"
            println("버튼을 눌렀습니다!")
            Log.i("MainActivity", ">>>>>>>> ${cnt} Hello Android - 이것은 Logcat에 출력")
            Log.v("MainActivity", ">>>>>>>> ${cnt} Hello Android - 이것은 Logcat에 출력")
            Log.w("MainActivity", ">>>>>>>> ${cnt} Hello Android - 이것은 Logcat에 출력")
            Log.e("MainActivity", ">>>>>>>> ${cnt} Hello Android - 이것은 Logcat에 출력")
            Log.d("MainActivity", ">>>>>>>> ${cnt} Hello Android - 이것은 Logcat에 출력")

            cnt[0]+=1;
        }

        val resetBtn = findViewById<Button>(R.id.resetBtn)
        resetBtn.setOnClickListener {
            editText.setText("")
            radioGroup.clearCheck();
            findViewById<TextView>(R.id.text4).setText("reset버튼 클릭됨");
        }

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)
            var radioBtnVal = ""
            if (selectedRadioButton != null) {
                radioBtnVal = selectedRadioButton.text.toString()
            } else {
                Toast.makeText(this@MainActivity, "옵션을 선택해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener;
            }
            val inputTxtVal = editText.text.toString()

            // 새로운 액티비티를 시작합니다.
            val intent = Intent(this@MainActivity, NewActivity::class.java)
            intent.putExtra("radioBtnVal", radioBtnVal)
            intent.putExtra("inputTxtVal", inputTxtVal)
            startActivity(intent)
        }
    }
}