package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtomBinding

class ButtomActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityButtomBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnNavigate.setOnClickListener {

            val username: String = binding.editTextText.text.toString()
            val password: String = binding.editTextTextPassword.text.toString()

            //things to remember after this for authentication..


            if (username.isEmpty()) {
                binding.editTextText.error = "Username Cannot be Empty"
            } else if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Password cannot be Empty"
            } else {
                var intent = Intent(
                    this@ButtomActivity,
                    DestinationActivity::class.java
                )

                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent)

            }
//
//        button.setOnClickListener{
//            val intent = Intent(this@ButtomActivity,FruitsActivity::class.java)
//            startActivity(intent)
//            finish()
//        }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}