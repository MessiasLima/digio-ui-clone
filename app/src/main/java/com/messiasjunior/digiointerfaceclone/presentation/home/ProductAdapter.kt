package com.messiasjunior.digiointerfaceclone.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.messiasjunior.digiointerfaceclone.databinding.RecyclerViewItemProductBinding
import com.messiasjunior.digiointerfaceclone.model.Product

class ProductAdapter : RecyclerView.Adapter<ProductViewHolder>() {
    private val products = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int) = ProductViewHolder.create(parent)

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bing(products[position])
    }

    fun setProducts(products: List<Product>) {
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}

class ProductViewHolder private constructor(
    private val binding: RecyclerViewItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bing(product: Product) {
        binding.imageUrl = product.imageURL
    }

    companion object {
        fun create(parent: ViewGroup): ProductViewHolder {
            val binding = RecyclerViewItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ProductViewHolder(binding)
        }
    }
}
