package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var radioApple:RadioButton
    lateinit var radioMango:RadioButton
    lateinit var radioGrapes:RadioButton
    lateinit var imageViewRadio: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)

        radioApple = findViewById(R.id.ButtonApple)
        radioMango = findViewById(R.id.Buttonmango)
        radioGrapes  = findViewById(R.id.ButtonGrapes)

        imageViewRadio = findViewById(R.id.imageViewRadio)


        radioApple.setOnClickListener{
            imageViewRadio.setImageResource(R.drawable.dog)
        }
        radioGrapes.setOnClickListener{
            imageViewRadio.setImageResource(R.drawable.dogg)
        }
        radioMango.setOnClickListener{
            imageViewRadio.setImageResource(R.drawable.images)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}