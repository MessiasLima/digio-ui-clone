package com.messiasjunior.digiointerfaceclone.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.messiasjunior.digiointerfaceclone.databinding.ViewPagerItemSpotlightBinding
import com.messiasjunior.digiointerfaceclone.model.SpotlightItem

class SpotlightAdapter(
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<SpotlightViewHolder>() {
    private val items = mutableListOf<SpotlightItem>()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int) =
        SpotlightViewHolder.create(parent)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SpotlightViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            viewModel.spotlightItemClicked(items[position])
        }
    }

    fun setItems(spotlight: List<SpotlightItem>) {
        items.addAll(spotlight)
        notifyDataSetChanged()
    }
}

class SpotlightViewHolder private constructor(
    private val binding: ViewPagerItemSpotlightBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(spotlightItem: SpotlightItem) {
        binding.spotlight = spotlightItem
    }

    companion object {
        fun create(parent: ViewGroup): SpotlightViewHolder {
            val binding = ViewPagerItemSpotlightBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return SpotlightViewHolder(binding)
        }
    }
}
