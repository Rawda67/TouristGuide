package com.example.touristguide.viewHotels

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.touristguide.Baron
import com.example.touristguide.Chedi
import com.example.touristguide.FourSeasons
import com.example.touristguide.HotelsContainer
import com.example.touristguide.Marriott
import com.example.touristguide.Oberoi
import com.example.touristguide.Pyramisa
import com.example.touristguide.Regis
import com.example.touristguide.Savoy
import com.example.touristguide.Sofitel
import com.example.touristguide.Steigenberger


class MyAdapter3(mainActivity: HotelsContainer) : FragmentStateAdapter(mainActivity) {

    private val fragmentCount = 10

    override fun getItemCount(): Int {
        return fragmentCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Savoy()
            1->Marriott()
            2->Steigenberger()
            3->FourSeasons()
            4->Oberoi()
            5->Baron()
            6->Regis()
            7->Chedi()
            8->Sofitel()
            9->Pyramisa()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}