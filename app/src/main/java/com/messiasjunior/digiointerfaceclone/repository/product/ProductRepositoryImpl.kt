package com.messiasjunior.digiointerfaceclone.repository.product

import com.messiasjunior.digiointerfaceclone.datasource.product.ProductRemoteDataSource

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {
    override suspend fun getProducts() = productRemoteDataSource.getProducts()
}
