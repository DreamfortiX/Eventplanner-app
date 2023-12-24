package com.example.eventplannerapp

// In AddEventActivity



import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.eventplannerapp.home.Companion.EXTRA_NEW_EVENT

class AddEventActivity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var id:EditText
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker

    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_event)

        // Initialize views
        editTextTitle = findViewById(R.id.editTextTitle)
        id = findViewById(R.id.id)
        editTextDescription = findViewById(R.id.editTextDescription)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()
            val id = id.text.toString()
            val imageView = "https://www.theknot.com/tk-media/images/8012ab72-7345-45ad-8aee-8cc047dbeefb.jpg".toString()
            val year = datePicker.year.toString()
            val month = datePicker.month.toString()
            val day = datePicker.dayOfMonth.toString()
            val date = "$year-$month-$day"

            val hour = timePicker.hour.toString()
            val minute = timePicker.minute.toString()
            val Time = "$hour:$minute"
            val eventData = Event(id,title, description,date,Time,imageView)
            val resultIntent = Intent(this, home::class.java)
            resultIntent.putExtra(EXTRA_NEW_EVENT, eventData) // Correct indentation

// Other code here

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
    companion object {
        const val ADD_EVENT_REQUEST_CODE = 1
        const val EXTRA_NEW_EVENT = "extra_new_event"
    }

}
