package com.example.touristguide

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.example.touristguide.model.placesEgypt

class Hotels : Fragment() {
    private lateinit var adapter: placesAdapter
    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private lateinit var originalList: MutableList<placesEgypt>
    private lateinit var filteredList: MutableList<placesEgypt>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_hotels, container, false)

        listView = view.findViewById(R.id.listView)
        searchView = view.findViewById(R.id.search)

        try {
            val searchText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            searchText?.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            searchText?.setHintTextColor(ContextCompat.getColor(requireContext(), R.color.grey))
        } catch (e: Exception) {
            Log.e("SearchView", "Error customizing search view text", e)
        }

        originalList = mutableListOf(
            placesEgypt("Savoy Sharm El Sheikh", "4.8", R.drawable.savoy),
            placesEgypt("Marriott Mena House", "4.9", R.drawable.marriott),
            placesEgypt("Steigenberger Resort Achti", "4.7", R.drawable.steigenberger),
            placesEgypt("Four Seasons Hotel", "4.9", R.drawable.fourseasons),
            placesEgypt("The Oberoi Beach Resort", "4.9", R.drawable.oberoi),
            placesEgypt("Baron Palace", "4.8", R.drawable.baron),
            placesEgypt("The St. Regis", "4.9", R.drawable.stregis),
            placesEgypt("The Chedi", "4.8", R.drawable.chedi),
            placesEgypt("Sofitel Winter Palace", "4.7", R.drawable.sofitel),
            placesEgypt("Pyramisa Suites Hotel", "4.6", R.drawable.pyramisa)
        )

        filteredList = originalList.toMutableList()
        context?.let { ctx ->
            adapter = placesAdapter(ctx, R.layout.list_item, filteredList)
            listView.adapter = adapter
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedPlace = filteredList[position] // العنصر المختار من القائمة بعد التصفية

            val originalIndex = originalList.indexOfFirst { it.name == selectedPlace.name }

            Log.d("Hotels", "Clicked: ${selectedPlace.name}, Original Index: $originalIndex")

            val selectedFragment: Fragment? = when (originalIndex) {
                0 -> Savoy()
                1 -> Marriott()
                2 -> Steigenberger()
                3 -> FourSeasons()
                4 -> Oberoi()
                5 -> Baron()
                6 -> Regis()
                7 -> Chedi()
                8 -> Sofitel()
                9 -> Pyramisa()
                else -> null
            }

            if (selectedFragment != null) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, selectedFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                Log.e("Hotels", "No fragment found for this position")
            }
        }

        // إضافة خاصية البحث بشكل صحيح داخل `onCreateView`
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        return view
    }

    private fun filterList(query: String?) {
        val searchQuery = query?.lowercase() ?: ""
        filteredList.clear()
        filteredList.addAll(originalList.filter { it.name.lowercase().contains(searchQuery) })
        adapter.notifyDataSetChanged()
    }
}
