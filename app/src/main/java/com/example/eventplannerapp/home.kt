package com.example.eventplannerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar

import com.example.eventplannerapp.databinding.ActivityHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class home : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewParty : RecyclerView
    private lateinit var recyclerviewOtherevents : RecyclerView
    private lateinit var binding: ActivityHomeBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar



    companion object {
        const val ADD_EVENT_REQUEST_CODE = 1
        const val EXTRA_NEW_EVENT = "extra_new_event"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerViewParty = findViewById(R.id.recyclerViewParty)
        recyclerviewOtherevents = findViewById(R.id.recyclerViewOther)
        toolbar = findViewById(R.id.toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout ,toolbar,  R.string.open,  R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation item clicks here
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()

                }
                R.id.nav_item2 -> {
                    Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_item3 ->{
                    Toast.makeText(this, "Contact us clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_item4 ->{
                    Toast.makeText(this, "Detail clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_item5 ->{
                    Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_item6 ->{
                    Toast.makeText(this, "Rate us clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_item7 ->{
                   startActivity(Intent(this,login::class.java))
                    finish()
                }
            }
            drawerLayout.closeDrawers()
            true
        }





        val chatlist: List<Event> = listOf(
            Event(
                "first",
                "Event 1",
                "Description 1",
                "2023-01-01",
                "03:10 AM",
                "https://www.theknot.com/tk-media/images/8012ab72-7345-45ad-8aee-8cc047dbeefb.jpg"
            ),
                Event(
                    "second",
                    "Event 2",
                    "Description 2",
                    "2023-02-02",
                    "02:30 PM",
                    "https://cdn0.hitched.co.uk/article/5110/3_2/960/png/140115-41-a-bride-and-groom-exiting-their-wedding-ceremony-as-guests-throw-white-confetti-over-them.jpeg"
                )
        )

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = EventAdapter(this, chatlist)


        val layoutManagerParty = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewParty.layoutManager = layoutManagerParty
        recyclerViewParty.adapter = EventAdapter(this, chatlist)




        val layoutManagerother = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewOtherevents.layoutManager = layoutManagerother
        recyclerviewOtherevents.adapter = EventAdapter(this, chatlist)


        val fabAddEvent: FloatingActionButton = findViewById(R.id.fabAddEvent)

        fabAddEvent.setOnClickListener {
            val intent = Intent(this, AddEventActivity::class.java)
            startActivityForResult(intent, ADD_EVENT_REQUEST_CODE)
        }




        fun createDefaultEvent(): Event {
            return Event("1", "Default Title", "Default Description", "2023-01-01", "00:00")
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == ADD_EVENT_REQUEST_CODE && resultCode == RESULT_OK) {
                // Retrieve the new event from AddEventActivity
                val newEvent = data?.getParcelableExtra<Event>(AddEventActivity.EXTRA_NEW_EVENT)
                val chatlist : MutableList<Event> = mutableListOf(createDefaultEvent())
                // Add the new event to the dataset and notify the adapter
                if (newEvent != null) {
                    chatlist.add(newEvent)
                    recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                    recyclerView.adapter = EventAdapter(this,chatlist)
                    EventAdapter.notifyItemInserted(chatlist.size - 1)
                }
            }
        }
    }

    private fun MutableList(size: Event, init: () -> Event): MutableList<Event> {
        return MutableList(size) {
            Event("1", "Default Title", "Default Description", "2023-01-01", "00:00")
        }
    }

}



