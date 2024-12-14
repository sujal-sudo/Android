package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.FruitsAdapter

class FruitsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val imageList = ArrayList<Int>()
    val nameList= ArrayList<String>()
    val descList= ArrayList<String>()

    lateinit var adapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruits)
        recyclerView=findViewById(R.id.recycleView)

        imageList.add(R.drawable.dog)
        imageList.add(R.drawable.dogg)
        imageList.add(R.drawable.images)

        nameList.add("dog")
        nameList.add(" Mr dogg")
        nameList.add("Shrek")

        descList.add("This is snoop's dog")
        descList.add("This is mr snoop dog")
        descList.add("This is shrek")



        adapter= FruitsAdapter(
            this@FruitsActivity,
            imageList, nameList, descList
        )

        recyclerView.adapter=adapter

        recyclerView.layoutManager= LinearLayoutManager(this@FruitsActivity)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}