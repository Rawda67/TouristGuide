package com.example.touristguide

import com.example.touristguide.Pyramids1
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.touristguide.model.placesEgypt

class Places : Fragment() {

    private lateinit var adapter: placesAdapter
    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private lateinit var originalList: MutableList<placesEgypt>
    private lateinit var filteredList: MutableList<placesEgypt>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_places, container, false)

        listView = view.findViewById(R.id.listView)
        searchView = view.findViewById(R.id.search)

        val searchText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
        searchText.setHintTextColor(ContextCompat.getColor(requireContext(), R.color.grey))

        originalList = mutableListOf(
            placesEgypt("Pyramids of Giza", "4.9", R.drawable.pyramid),
            placesEgypt("Abu Simbel Temples", "4.8", R.drawable.abu),
            placesEgypt("Luxor Temple", "4.8", R.drawable.luxortemple),
            placesEgypt("Karnak Temple", "4.9", R.drawable.karnak),
            placesEgypt("Valley of the Kings", "4.9", R.drawable.valley),
            placesEgypt("Egyptian Museum", "4.7", R.drawable.museum),
            placesEgypt("Saqqara Necropolis", "4.8", R.drawable.saqqara),
            placesEgypt("White Desert", "4.7", R.drawable.whitedesert),
            placesEgypt("Aswan’s Philae Temple", "4.8", R.drawable.aswanphilae),
            placesEgypt("Mount Sinai", "4.6", R.drawable.mountsinai),
            placesEgypt("Alexandria Library", "4.7", R.drawable.alexlibrary),
            placesEgypt("Siwa Oasis", "4.7", R.drawable.siwa),
            placesEgypt("Dahab (Blue Hole)", "4.6", R.drawable.dahab),
            placesEgypt("Temple of Hatshepsut", "4.7", R.drawable.hatshepsut),
            placesEgypt("Salah El-Din Citadel", "4.7", R.drawable.salah)
        )

        filteredList = originalList.toMutableList()
        adapter = placesAdapter(requireContext(), R.layout.list_item, filteredList)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedFragment: Fragment? = when (position) {
                0 -> Pyramids1()
                1 -> AbuSimbelTemples()
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
                else -> null
            }

            if (selectedFragment != null) {
                Log.d("Places", "Navigating to: ${selectedFragment::class.java.simpleName}")

                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, selectedFragment)
                    .addToBackStack(null).commit()
            } else {
                Log.e("Places", "Fragment is null! Check the position mapping.")
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        return view
    }

    private fun filterList(query: String?) {
        filteredList.clear()
        if (query.isNullOrEmpty()) {
            filteredList.addAll(originalList)
        } else {
            val searchQuery = query.lowercase()
            for (place in originalList) {
                if (place.name.lowercase().contains(searchQuery)) {
                    filteredList.add(place)
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
}