package com.example.touristguide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class AbuSimbelTemples : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_abu_simbel_temples, container, false)

        val mapbtn = view.findViewById<Button>(R.id.open_map_button)

        mapbtn.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:22.3372,31.6258?q=معبد+أبو+سمبل")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }


        return view
    }
}
