package com.example.touristguide.viewPlaces

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.touristguide.AbuSimpel
import com.example.touristguide.AlexandriaLibrary
import com.example.touristguide.AswanPhilae
import com.example.touristguide.Dahab
import com.example.touristguide.Hatshepsut
import com.example.touristguide.KarnakTemple
import com.example.touristguide.LuxorTemple
import com.example.touristguide.MountSinai
import com.example.touristguide.Museum
import com.example.touristguide.PlacesContainer
import com.example.touristguide.SalahElDin
import com.example.touristguide.Saqqara
import com.example.touristguide.SiwaOasis
import com.example.touristguide.Valley
import com.example.touristguide.Whitedesert
import com.example.touristguide.Pyramids1 // Add this import

class myAdapter2(mainActivity: PlacesContainer) : FragmentStateAdapter(mainActivity) {

    private val fragmentCount = 15

    override fun getItemCount(): Int {
        return fragmentCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Pyramids1()
            1 -> AbuSimpel()
            2 -> LuxorTemple()
            3 -> KarnakTemple()
            4 -> Valley()
            5 -> Museum()
            6 -> Saqqara()
            7 -> Whitedesert()
            8 -> AswanPhilae()
            9 -> MountSinai()
            10 -> AlexandriaLibrary()
            11 -> SiwaOasis()
            12 -> Dahab()
            13 -> Hatshepsut()
            14 -> SalahElDin()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}