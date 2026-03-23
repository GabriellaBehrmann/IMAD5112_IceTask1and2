package com.example.icetask12

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.icetask12.R

class SecondActivity : AppCompatActivity() {


    enum class Times {
        MORNING,
        MID_MORNING,
        AFTERNOON,
        SNACK_TIME,
        EVENING,
        NIGHT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val spinner = findViewById<Spinner>(R.id.timeSpinner)
        val resultText = findViewById<TextView>(R.id.resultText)
        val button = findViewById<Button>(R.id.showButton)


        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            Times.values()
        )


        button.setOnClickListener {

            val selectedTime = spinner.selectedItem as Times
            var suggestion = ""


            when (selectedTime) {

                Times.MORNING ->
                    suggestion = "Review your notes from yesterday's lecture for 15 minutes."

                Times.MID_MORNING ->
                    suggestion = "Tackle your most difficult assignment while your focus is high."

                Times.AFTERNOON ->
                    suggestion = "Take a 10-minute break, stretch, and drink water."

                Times.SNACK_TIME ->
                    suggestion = "Do a quick 5-minute revision quiz."

                Times.EVENING ->
                    suggestion = "Organise your notes and create a to-do list."

                Times.NIGHT ->
                    suggestion = "Read over your goals and prepare your bag."

            }


            resultText.text = suggestion
        }
    }
}