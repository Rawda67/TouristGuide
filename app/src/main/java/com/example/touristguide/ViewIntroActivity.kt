package com.example.touristguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.touristguide.viewIntro.myAdapter

class ViewIntroActivity : AppCompatActivity() {
    lateinit var myAdapter : myAdapter
    lateinit var ViewPager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_intro)
        myAdapter = myAdapter(this)
        ViewPager = findViewById(R.id.viewPager)
        ViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        ViewPager.adapter = myAdapter
    }
}