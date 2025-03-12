package com.example.touristguide.viewIntro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.touristguide.Places
import com.example.touristguide.Hotels
import com.example.touristguide.Favourits

class myAdapter1(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3 // Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Places()
            1 -> Hotels()
            2 -> Favourits()
            else -> Places()
        }
    }
}
