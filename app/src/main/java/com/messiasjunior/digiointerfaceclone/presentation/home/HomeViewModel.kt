package com.messiasjunior.digiointerfaceclone.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.messiasjunior.digiointerfaceclone.model.Product
import com.messiasjunior.digiointerfaceclone.model.ProductDTO
import com.messiasjunior.digiointerfaceclone.model.ProductsApiResponse
import com.messiasjunior.digiointerfaceclone.model.SpotlightItem
import com.messiasjunior.digiointerfaceclone.repository.product.ProductRepository
import com.messiasjunior.digiointerfaceclone.util.Resource
import com.messiasjunior.digiointerfaceclone.util.event.Event

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

    private val _productClickedEvent = MutableLiveData<ProductDTO>()

    val productClickedEvent: LiveData<Event<ProductDTO>> = _productClickedEvent.map {
        return@map Event(it)
    }

    fun spotlightItemClicked(spotlightItem: SpotlightItem) {
        _productClickedEvent.value = ProductDTO(
            spotlightItem.name,
            spotlightItem.description,
            spotlightItem.bannerURL
        )
    }

    fun productClicked(product: Product) {
        _productClickedEvent.value = ProductDTO(
            product.name,
            product.description,
            product.imageURL
        )
    }

    fun cashClicked() {
        _productsApiResponse.value?.let {
            _productClickedEvent.value = ProductDTO(
                it.cash.title,
                it.cash.description,
                it.cash.bannerURL
            )
        }
    }
}
