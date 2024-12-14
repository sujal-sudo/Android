package com.example.myapplication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var textview: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var dateText: EditText


    val countries = arrayOf("Nepal","India","China","Japan","USA")

    val cities = arrayOf("KTM","BKT","LTP","KNC","KRT")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.spinner)
        textview= findViewById(R.id.textView4)
        autoCompleteTextView= findViewById(R.id.autoCompleteTextView)
        dateText= findViewById(R.id.DateText)


        dateText.isFocusable= false
        dateText.isClickable= true

        dateText.setOnClickListener{
            loadCalendar()
        }





        val adapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item,

        )


        var autoAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold=1



        spinner.adapter = adapter

        spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c= Calendar.getInstance()
        val year= c.get(Calendar.YEAR)
        val month= c.get(Calendar.MONTH)
        val days= c.get(Calendar.DAY_OF_MONTH)


        val dialog= DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener
            { datePicker, year, month, day ->
                dateText.setText("$year/${month+1}/$day")

            } , year , month , days
        )
        dialog.show()





    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(p0 != null){
            textview.text = p0.getItemAtPosition(p2).toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}