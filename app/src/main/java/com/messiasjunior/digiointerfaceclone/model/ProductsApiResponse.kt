package com.messiasjunior.digiointerfaceclone.model

data class ProductsApiResponse(
    val spotlight: List<SpotlightItem>,
    val products: List<Product>,
    val cash: CashProduct
)
