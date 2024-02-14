package ru.yandex.practicum.sprint9koh14

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    companion object {
        var themeResId = R.style.Theme_Sprint9koh14
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(themeResId)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<MaterialButton>(R.id.theme1).setOnClickListener {
            themeResId = R.style.Theme_Sprint9koh14
            recreate()
        }
        findViewById<MaterialButton>(R.id.theme2).setOnClickListener {
            themeResId = R.style.Theme_Sprint9koh14_Alternative
            recreate()
        }
    }
}