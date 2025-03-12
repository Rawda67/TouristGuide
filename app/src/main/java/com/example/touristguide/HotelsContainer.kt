package com.example.touristguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.touristguide.viewHotels.MyAdapter3
import com.example.touristguide.viewPlaces.myAdapter2

class HotelsContainer: AppCompatActivity() {
    private lateinit var myAdapter3: MyAdapter3
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable edge-to-edge display
        setContentView(R.layout.activity_hotels_container)

        // Initialize ViewPager2
        viewPager = findViewById(R.id.viewPager3) // Ensure this ID matches your layout file
        myAdapter3 = MyAdapter3(this)

        // Set up ViewPager2
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = myAdapter3

        // Handle system insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}