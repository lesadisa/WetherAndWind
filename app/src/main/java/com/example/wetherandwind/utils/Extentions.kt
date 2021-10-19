package com.example.wetherandwind.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.*

fun EditText.setDebouncingTextListener(
    debouncePeriod: Long = 300,
    onTextChange: (String) -> Unit
) {

    addTextChangedListener(object : TextWatcher {

        private var timer = Timer()

        override fun onTextChanged(newText: CharSequence?, p1: Int, p2: Int, p3: Int) {
            timer.cancel()
            timer = Timer()
            timer.schedule(
                object : TimerTask() {
                    override fun run() {
                        post {
                            onTextChange(newText.toString())
                        }
                    }
                },
                debouncePeriod
            )
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
        }
    })
}