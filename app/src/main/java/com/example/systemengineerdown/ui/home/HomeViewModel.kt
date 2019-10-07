package com.example.systemengineerdown.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Mecanica São Marcelo"
    }
    val text: LiveData<String> = _text
}