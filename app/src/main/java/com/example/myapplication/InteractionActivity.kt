package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class InteractionActivity : AppCompatActivity() {
    lateinit var btnsnack : Button
    lateinit var btnalert : Button
    lateinit var btntoast   : Button
    lateinit var  main : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interaction)

        main = findViewById(R.id.main)
        btnsnack = findViewById(R.id.btnsnack)
        btnalert = findViewById(R.id.btnalert)
        btntoast = findViewById(R.id.btntoast)

        btntoast.setOnClickListener{
            Toast.makeText(this@InteractionActivity,"Login Success", Toast.LENGTH_LONG
            ).show()
        }

        btnalert.setOnClickListener{
            val alerts = AlertDialog.Builder(this@InteractionActivity)
            alerts.setTitle("Conformation")
                .setMessage("Are you sure")
                .setIcon(R.drawable.dog )
                .setNegativeButton("No",DialogInterface.OnClickListener
                {dialogInterface, i ->  dialogInterface.dismiss()
                })
                .setPositiveButton("Yes",DialogInterface.OnClickListener
                {dialogInterface, i -> dialogInterface.dismiss()
                })
            alerts.create().show()
        }



        btnsnack.setOnClickListener{
            Snackbar.make(main,"Invalid Login",
                Snackbar.LENGTH_LONG
            ).setAction("close",{}).show()
        }
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}