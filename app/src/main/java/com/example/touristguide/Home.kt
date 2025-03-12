package com.example.touristguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.touristguide.viewIntro.myAdapter1
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Home : AppCompatActivity() {

    private val myTabs = arrayOf("Places", "Hotels", "Favorites")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val homeView = findViewById<ViewPager2>(R.id.home)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val myAdapter = myAdapter1(this)
        homeView.adapter = myAdapter

        TabLayoutMediator(tabLayout, homeView) { tab, position ->
            tab.text = myTabs[position]
        }.attach()
    }
}
