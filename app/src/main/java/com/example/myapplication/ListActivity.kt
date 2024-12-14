package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity() {
    lateinit var  listView: ListView

    val contacts = arrayOf("Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Ram","Shyanm",
        "Sita","Shyanm",
        "Ram","Gita",
        "Sita","Shyanm",
        "Sita","Shyanm",
        "Sita","Shyanm",
        "Sita","Shyanm",
        "Ram","Gita",
        "Ram","Gita",
        "Ram","Gita",
        "Ram","Gita",
        "Ram","Hari"
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        listView= findViewById(R.id.ListView)


        var adapter = ArrayAdapter(
            this@ListActivity,
            android.R.layout.simple_list_item_1,
            contacts
        )

//        listView.adapter = adapter
//        listView.setOnItemClickListener{
//            adapterView , view, postition, l->
//            if(adapterView ! = null){
//            Toast.makeText(
//                this@ListActivity,
//                adapterView.getItemAtPosition(position).toString(),
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}