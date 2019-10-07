package com.example.systemengineerdown.ui.tools

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FerramentasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Funcionalidades"
    }
    val text: LiveData<String> = _text
}