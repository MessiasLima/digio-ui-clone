package com.messiasjunior.digiointerfaceclone.datasource.product

import com.messiasjunior.digiointerfaceclone.datasource.ProductAPI
import com.messiasjunior.digiointerfaceclone.model.ProductsApiResponse
import retrofit2.awaitResponse

class ProductRemoteDataSourceImpl(
    private val productAPI: ProductAPI
) : ProductRemoteDataSource {
    override suspend fun getProducts(): ProductsApiResponse {
        return productAPI.getProducts().awaitResponse().body()!!
    }
}
