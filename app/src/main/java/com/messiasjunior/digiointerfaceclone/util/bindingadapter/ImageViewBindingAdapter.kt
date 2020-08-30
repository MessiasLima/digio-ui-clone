package com.messiasjunior.digiointerfaceclone.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImageURL(view: ImageView, imageUrl: String) {
    Glide.with(view)
        .load(imageUrl)
        .into(view)
}
