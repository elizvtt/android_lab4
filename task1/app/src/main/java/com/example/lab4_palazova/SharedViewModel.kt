package com.example.lab4_palazova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val count = MutableLiveData(0)
    val counter: LiveData<Int> = count

    fun increment() {
        count.value = count.value!! + 1
    }

    fun decrement() {
        count.value = count.value!! - 1
    }
}