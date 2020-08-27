package com.messiasjunior.digiointerfaceclone.presentation.home

import androidx.lifecycle.ViewModel
import com.messiasjunior.digiointerfaceclone.repository.ProductRepository

class HomeViewModel(
    private val productRepository: ProductRepository
) : ViewModel()
