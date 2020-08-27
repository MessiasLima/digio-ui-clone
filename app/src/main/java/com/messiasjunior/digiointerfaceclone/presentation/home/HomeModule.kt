package com.messiasjunior.digiointerfaceclone.presentation.home

import com.messiasjunior.digiointerfaceclone.repository.ProductRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory { ProductRepository() }
    viewModel { HomeViewModel(get()) }
}
