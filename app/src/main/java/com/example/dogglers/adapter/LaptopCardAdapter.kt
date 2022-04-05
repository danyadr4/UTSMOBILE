package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource

class LaptopCardAdapter(
    private val context: Context?,
    private val layout: Int

): RecyclerView.Adapter<LaptopCardAdapter.DogCardViewHolder>() {

    val laptopList = DataSource.LAPTOPS

    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val laptopImageView : ImageView? = view?.findViewById(R.id.laptop_img)
        val laptopNameText : TextView? = view?.findViewById(R.id.laptop_name)
        val laptopBrandText : TextView? = view?.findViewById(R.id.laptop_brand)
        val laptopPriceText : TextView? = view?.findViewById(R.id.laptop_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        val adapterLayout = when (layout) {
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return laptopList.size
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dogData = laptopList[position]
        holder.laptopImageView?.setImageResource(dogData.imageResourceId)
        holder.laptopNameText?.text = dogData.name
        val resources = context?.resources
        holder.laptopBrandText?.text = dogData.brand

        holder.laptopPriceText?.text = dogData.price



    }
}
