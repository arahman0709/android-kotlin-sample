package com.lmorda.shopper.store

import androidx.lifecycle.*
import com.lmorda.shopper.data.FoodItem
import com.lmorda.shopper.data.StoreRepository
import kotlinx.coroutines.launch

class StoreViewModel(private val storeRepository: StoreRepository) : ViewModel() {

    val storeItems = storeRepository.storeItems

    private val _cartUpdated = MutableLiveData<Boolean>()
    val cartUpdated: LiveData<Boolean> = _cartUpdated

    private val _cartNum = MutableLiveData<Int>()
    val cartNum: LiveData<Int> = _cartNum

    fun getCartNum() = viewModelScope.launch {
        _cartNum.postValue(storeRepository.getCartNum())
    }

    fun updateCart(foodItem: FoodItem, isAdd: Boolean) =
        viewModelScope.launch {
            _cartUpdated.postValue(storeRepository.updateCart(foodItem, isAdd))
        }


    fun createOrder() = liveData {
        emit(storeRepository.createOrder())
    }
}
