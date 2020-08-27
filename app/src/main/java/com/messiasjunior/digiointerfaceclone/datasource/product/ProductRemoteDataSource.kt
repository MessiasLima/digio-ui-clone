package com.messiasjunior.digiointerfaceclone.datasource.product

import com.messiasjunior.digiointerfaceclone.model.ProductsApiResponse

interface ProductRemoteDataSource {
    suspend fun getProducts(): ProductsApiResponse
}
