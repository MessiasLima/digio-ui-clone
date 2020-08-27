package com.messiasjunior.digiointerfaceclone.datasource

import com.messiasjunior.digiointerfaceclone.model.ProductsApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
    @GET("/sandbox/products")
    fun getProducts(): Call<ProductsApiResponse>
}
