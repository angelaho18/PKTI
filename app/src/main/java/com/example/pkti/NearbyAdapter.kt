package com.example.pkti

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pkti.NearbyAdapter.CardHolder

class NearbyAdapter : RecyclerView.Adapter<NearbyAdapter.CardHolder>(){
    class CardHolder (val view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflateView = LayoutInflater.from(parent.context)
            .inflate(R.layout.nearbyme_desginer, parent, false)
        return CardHolder(inflateView)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
    }

    override fun getItemCount(): Int = 5


}