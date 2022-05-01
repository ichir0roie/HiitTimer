package com.example.hiittimer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _laps=MutableLiveData(0)
    val laps:LiveData<Int> = _laps
    fun lapsAdd(num:Int){
        _laps.value=(_laps.value ?: 0) + num
    }
    private val _run=MutableLiveData(0)
    val run:LiveData<Int> = _run
    fun runAdd(num:Int){
        _run.value=(_run.value ?: 0) + num
    }
    private val _rest=MutableLiveData(0)
    val rest:LiveData<Int> = _rest
    fun restAdd(num:Int){
        _rest.value=(_rest.value ?: 0) + num
    }
}