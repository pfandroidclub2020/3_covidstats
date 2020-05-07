package net.pilsfree.covidstats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.pilsfree.covidstats.R
import net.pilsfree.covidstats.model.Country

class CountryAdapter(val list: List<Country>, val onclick: (Int) -> Unit)
    : RecyclerView.Adapter<CountryAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val view = holder.itemView
        val zeme = view.findViewById<TextView>(R.id.zeme)
        zeme.text = list[position].Country

        val vlajka = view.findViewById<ImageView>(R.id.vlajka)

        Picasso.with(view.context)
            .load("https://cdn.jsdelivr.net/npm/svg-country-flags@1.2.7/png100px/${list[position].ISO2.toLowerCase()}.png")
            .into(vlajka)

        view.setOnClickListener {
            onclick(position)
        }

    }
}