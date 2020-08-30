package com.messiasjunior.digiointerfaceclone.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.messiasjunior.digiointerfaceclone.R

@BindingAdapter("imageUrl")
fun loadImageURL(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view)
            .load(it)
            .placeholder(R.drawable.ic_default_picture)
            .fallback(R.drawable.ic_default_picture)
            .into(view)
    }
}
