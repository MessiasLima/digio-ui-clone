package com.messiasjunior.digiointerfaceclone.presentation.home

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class SpotlightPageTransformer(
    private val viewpagerOffset: Int
) : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val offset = position * -(viewpagerOffset)
        page.translationX = offset
    }
}
