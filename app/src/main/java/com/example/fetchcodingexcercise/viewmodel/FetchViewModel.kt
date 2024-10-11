package com.example.fetchcodingexcercise.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchcodingexcercise.ui.theme.FetchItem
import com.example.fetchcodingexcercise.data.FetchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FetchViewModel() : ViewModel() {

    var readAll: MutableState<List<FetchItem>> = mutableStateOf(emptyList())
    val repository = FetchRepository()
    fun getHiring() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val value = repository.getHiring()
                readAll.value = value
            } catch (e : Exception) {
                Log.e("FetchViewModel", "call exception", e)
            }

        }
    }
}