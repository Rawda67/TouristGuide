package com.example.touristguide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LuxorTemple.newInstance] factory method to
 * create an instance of this fragment.
 */
class LuxorTemple : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_luxor_temple, container, false)

        val mapbtn = view.findViewById<Button>(R.id.open_map_button)

        mapbtn.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:29.9792,31.1342?q=معبد+الاقصر")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }


        return view
    }

}