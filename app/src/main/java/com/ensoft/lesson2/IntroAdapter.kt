package com.ensoft.lesson2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IntroAdapter(val introList: List<IntroItem>) : RecyclerView.Adapter<IntroAdapter.IntroViewHolder>() {
    inner class IntroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun onBind(item: IntroItem){
            val imageIntro = itemView.findViewById<ImageView>(R.id.imageIntro)
            val titleIntro = itemView.findViewById<TextView>(R.id.titleIntro)
            val descIntro = itemView.findViewById<TextView>(R.id.descIntro)

            imageIntro.setImageResource(item.image)
            titleIntro.text = item.title
            descIntro.text = item.desc

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        return IntroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.container_item, parent, false))
    }

    override fun getItemCount(): Int {
        return introList.size
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.onBind(introList[position])
    }
}