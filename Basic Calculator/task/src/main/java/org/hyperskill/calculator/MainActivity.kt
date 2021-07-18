package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var strContentEditText: String
        var firstValue = 0.0
        var strFirstValue = ""
        var secondValue: Double
        var isTypingFirstValue: Boolean
        var strOperation = ""
        var result: Double

        val mEditText = findViewById<EditText>(R.id.editText)
        mEditText.setText("")
        isTypingFirstValue = true

        findViewById<Button>(R.id.button1).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"1")
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"2")
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"3")
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"4")
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"5")
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"6")
        }
        findViewById<Button>(R.id.button7).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"7")
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"8")
        }
        findViewById<Button>(R.id.button9).setOnClickListener {
            mEditText.setText(mEditText.getText().toString()+"9")
        }
        findViewById<Button>(R.id.button0).setOnClickListener {
            strContentEditText = mEditText.getText().toString()
            if (strContentEditText != "0") {
                mEditText.setText(strContentEditText + "0")
            }
        }
        findViewById<Button>(R.id.clearButton).setOnClickListener {
            mEditText.setHint("")
            mEditText.setText("")
        }
        findViewById<Button>(R.id.dotButton).setOnClickListener {
            strContentEditText = mEditText.getText().toString()
            if (!strContentEditText.contains('.')) {
                mEditText.setText(mEditText.getText().toString()+".")
            }
        }

        fun finishToEnterValue(){
            if (isTypingFirstValue){
                isTypingFirstValue = false
                strFirstValue = mEditText.getText().toString()
                firstValue = strFirstValue.toDouble()
                mEditText.setHint(strFirstValue)
                mEditText.setText("")
            }

        }

        findViewById<Button>(R.id.addButton).setOnClickListener {
            strOperation = "+"
            finishToEnterValue()
        }

        findViewById<Button>(R.id.subtractButton).setOnClickListener {
            if (mEditText.length() == 0) {
                mEditText.setText("-")
            } else {
                strOperation = "-"
                finishToEnterValue()
            }
        }

        findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            strOperation = "*"
            finishToEnterValue()
        }

        findViewById<Button>(R.id.divideButton).setOnClickListener {
            strOperation = "/"
            finishToEnterValue()
        }

        fun setTextWithCorrection(res: Double) {
            if (Math.floor(res) == res) {
                mEditText.setText(res.toInt().toString())
            } else {
                mEditText.setText(res.toString())
            }
        }

        findViewById<Button>(R.id.equalButton).setOnClickListener {
            if (!isTypingFirstValue) {
                secondValue = mEditText.getText().toString().toDouble()
                if (strOperation == "+") {
                    result = firstValue + secondValue
                    setTextWithCorrection(result)
                } else if (strOperation == "-") {
                    result = firstValue - secondValue
                    setTextWithCorrection(result)
                } else if (strOperation == "*") {
                    result = firstValue * secondValue
                    setTextWithCorrection(result)
                } else if (strOperation == "/") {
                    result = firstValue / secondValue
                    setTextWithCorrection(result)
                }
                isTypingFirstValue = true
            }

        }

    }
}