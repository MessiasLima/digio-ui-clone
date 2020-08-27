package com.messiasjunior.digiointerfaceclone.repository.product

import com.messiasjunior.digiointerfaceclone.model.ProductsApiResponse

interface ProductRepository {
    suspend fun getProducts(): ProductsApiResponse
}
