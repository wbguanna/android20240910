package com.example.day01ex01.component

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText

class MyEventSettedEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {

    private val TAG = "실행된것?"

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent): Boolean {
        if (event.getAction() === KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                clearFocus()
                // Focus_Helper.releaseFocus (etx_email_input);
            }
        }
        return super.onKeyPreIme(keyCode, event)
    }
}