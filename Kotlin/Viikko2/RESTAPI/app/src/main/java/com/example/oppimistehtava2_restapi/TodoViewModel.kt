package com.example.oppimistehtava2_restapi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    var todos by mutableStateOf<List<Todo>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun loadTodos() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null

            try {
                todos = RetrofitInstance.api.getTodos()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                errorMessage = e.message ?: "Unknown error"
            } finally {
                isLoading = false
            }
        }
    }
}