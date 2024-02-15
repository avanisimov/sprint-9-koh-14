package ru.yandex.practicum.sprint9koh14

import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.text.method.BaseKeyListener
import android.text.method.KeyListener
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.View.OnKeyListener
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    companion object {
        var themeResId = R.style.Theme_Sprint9koh14
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(themeResId)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawable =
            ResourcesCompat.getDrawable(resources, R.drawable.baseline_arrow_back_24, theme)
        if (drawable != null) {
            DrawableCompat.setTint(drawable, resources.getColor(R.color.navigation_icon_color, theme))
        }
        findViewById<Toolbar>(R.id.toolbar).apply {
            navigationIcon = drawable
        }

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


        findViewById<MaterialButton>(R.id.theme1).setOnClickListener {
            themeResId = R.style.Theme_Sprint9koh14
            recreate()
        }
        findViewById<MaterialButton>(R.id.theme2).setOnClickListener {
            themeResId = R.style.Theme_Sprint9koh14_Alternative
            recreate()
        }


        val editText: EditText = findViewById(R.id.edit_text)

//        editText.keyListener = object : BaseKeyListener() {
//            override fun getInputType(): Int {
//                TODO("Not yet implemented")
//            }
//
//            override fun onKeyDown(
//                view: View?,
//                content: Editable?,
//                keyCode: Int,
//                event: KeyEvent?
//            ): Boolean {
//                return super.onKeyDown(view, content, keyCode, event)
//            }
//        }

//        editText.addTextChangedListener(object: TextWatcher {
//            var isEditing = false
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                Log.d("SPRINT_9", "beforeTextChanged s=$s start=$start count=$count after=$after")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("SPRINT_9", "onTextChanged s=$s start=$start before=$before count=$count")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                Log.d("SPRINT_9", "afterTextChanged s=$s")
//                if (!isEditing) {
//                    isEditing = true
//                    s?.append("1")
//                    isEditing = false
//                }
//            }
//
//        })
        editText.addTextChangedListener(PhoneNumberFormattingTextWatcher())
    }
}