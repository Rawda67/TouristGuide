package com.example.touristguide.viewIntro

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.touristguide.AbuSimpel
import com.example.touristguide.Luxor
import com.example.touristguide.Pyramids

class myAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragmentCount = 3

    override fun getItemCount(): Int {
        return fragmentCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Pyramids()
            1 -> AbuSimpel()
            2 -> Luxor()
            else -> Pyramids()
        }
    }
}
