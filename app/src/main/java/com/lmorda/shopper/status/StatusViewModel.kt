package com.lmorda.shopper.status

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.lmorda.shopper.data.StatusRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class StatusViewModel(private val statusRepository: StatusRepository) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getOrderStatus() = liveData {
        statusRepository.processOrder
            .onStart { _loading.postValue(true) }
            .onCompletion { _loading.postValue(false) }
            .collect { status -> emit(status) }
    }
}