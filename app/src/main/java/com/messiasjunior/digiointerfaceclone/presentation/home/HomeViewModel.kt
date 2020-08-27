package com.messiasjunior.digiointerfaceclone.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.messiasjunior.digiointerfaceclone.model.ProductsApiResponse
import com.messiasjunior.digiointerfaceclone.repository.product.ProductRepository
import com.messiasjunior.digiointerfaceclone.util.Resource

class HomeViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _productsApiResponseResource = liveData {
        emit(Resource.loading())
        emit(Resource.success(productRepository.getProducts()))
    }

    private val _productsApiResponse = MediatorLiveData<ProductsApiResponse>().apply {
        addSource(_productsApiResponseResource) {
            if (it.isSuccess()) {
                value = it.data
            }
        }
    }

    val productsApiResponse: LiveData<ProductsApiResponse> = _productsApiResponse

    val isLoading = _productsApiResponseResource.map { it.isLoading() }

    val isError = _productsApiResponseResource.map { it.isError() }
}
