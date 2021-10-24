package com.example.avengers_rating.ui.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avengers_rating.R
import com.example.avengers_rating.data.models.AvengersModel
import kotlinx.android.synthetic.main.item_avenger.view.*
import java.util.*

class AvengerAdapter(private val list: List<AvengersModel>) :
    RecyclerView.Adapter<AvengerAdapter.AvengerViewHolder>() {
    class AvengerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(avengerModel: AvengersModel) {
            with(itemView) {
                val colors = resources.getIntArray(R.array.random_color)
                val randomColor = colors[Random().nextInt(colors.size)]
                viewColorTag.setBackgroundColor(randomColor)
                avengerTv.text = avengerModel.avenger_name
                if (!avengerModel.rated) {
                    ratingTv.text = "Not Rated"
                } else {
                    when (avengerModel.stars) {
                        1 -> {
                            ratingTv.text = "Normal"
                        }
                        2 -> {
                            ratingTv.text = "Very Good"
                        }
                        else -> {
                            ratingTv.text = "Awesome"
                        }
                    }
                }
                avengerImageView.setImageDrawable(Drawable.createFromPath(avengerModel.avenger_image))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengerViewHolder {
        return AvengerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_avenger, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AvengerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long {
        return list[position].id
    }
}