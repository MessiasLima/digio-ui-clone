package com.messiasjunior.digiointerfaceclone.presentation.home

import com.messiasjunior.digiointerfaceclone.datasource.product.ProductRemoteDataSource
import com.messiasjunior.digiointerfaceclone.datasource.product.ProductRemoteDataSourceImpl
import com.messiasjunior.digiointerfaceclone.repository.product.ProductRepository
import com.messiasjunior.digiointerfaceclone.repository.product.ProductRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory<ProductRemoteDataSource> { ProductRemoteDataSourceImpl(get()) }
    factory<ProductRepository> { ProductRepositoryImpl(get()) }
    viewModel { HomeViewModel(get()) }
}
