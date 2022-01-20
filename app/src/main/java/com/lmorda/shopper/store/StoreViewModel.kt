package com.lmorda.shopper.store

import androidx.lifecycle.*
import com.lmorda.shopper.data.models.FoodItem
import com.lmorda.shopper.data.ShopperRepository
import kotlinx.coroutines.launch

class StoreViewModel(private val shopperRepository: ShopperRepository) : ViewModel() {

    val storeItems = shopperRepository.storeItems

    private val _cartUpdated = MutableLiveData<Boolean>()
    val cartUpdated: LiveData<Boolean> = _cartUpdated

    private val _cartNum = MutableLiveData<Int>()
    val cartNum: LiveData<Int> = _cartNum

    fun getCartNum() = viewModelScope.launch {
        _cartNum.postValue(shopperRepository.getCartNum())
    }

    fun updateCart(foodItem: FoodItem, isAdd: Boolean) =
        viewModelScope.launch {
            _cartUpdated.postValue(shopperRepository.updateCart(foodItem, isAdd))
        }


    fun createOrder() = liveData {
        emit(shopperRepository.createOrder())
    }
}
