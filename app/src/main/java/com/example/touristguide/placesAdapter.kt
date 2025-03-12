package com.example.touristguide

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.touristguide.model.placesEgypt

class placesAdapter (var mCtx:Context ,var resources:Int,var item:List<placesEgypt>)
    :ArrayAdapter<placesEgypt>(mCtx,resources,item){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater =LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources,null)

        val imageView = view.findViewById<ImageView>(R.id.imageView2)
        val placeName = view.findViewById<TextView>(R.id.textView1)
        val rate = view.findViewById<TextView>(R.id.rate)

        var place :placesEgypt =item[position]
        imageView.setImageDrawable(mCtx.resources.getDrawable(place.Img))
        placeName.text=place.name
        rate.text=place.rate

        return view
    }



}