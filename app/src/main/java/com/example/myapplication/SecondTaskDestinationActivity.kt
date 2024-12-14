package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.PhotoAdapter2
import com.example.myapplication.databinding.ActivitySecondTaskDestinationBinding

class SecondTaskDestinationActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySecondTaskDestinationBinding

    // Data Lists for RecyclerView
    private val imageList = arrayListOf(R.drawable.dog, R.drawable.dogg, R.drawable.images)
    private val nameList = arrayListOf("Facts", "meme", "fun")
    private val descList = arrayListOf("Dogg", "I am snoops dogg", "Let the world bark")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivitySecondTaskDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle System Insets for Edge-to-Edge Layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Display User Data from Intent
        displayUserData()

        // Setup RecyclerView
        setupRecyclerView()
    }

    private fun displayUserData() {
        // Get the data from the Intent
        val fullName = intent.getStringExtra("FULL_NAME") ?: "N/A"
        val email = intent.getStringExtra("EMAIL") ?: "N/A"
        val gender = intent.getStringExtra("GENDER") ?: "N/A"
        val country = intent.getStringExtra("COUNTRY") ?: "N/A"
        val city = intent.getStringExtra("CITY") ?: "N/A"

        // Display the data in the UI
        binding.textViewFullName.text = "Full Name: $fullName"
        binding.textViewEmail.text = "Email: $email"
        binding.textViewGender.text = "Gender: $gender"
        binding.textViewCountry.text = "Country: $country"
        binding.textViewCity.text = "City: $city"
    }

    private fun setupRecyclerView() {
        // RecyclerView Adapter
        val adapter = PhotoAdapter2(this, imageList, nameList, descList)

        // Setup RecyclerView with GridLayoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
    }
}