package org.example.project.presentation.component.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.models.AutoParte
import domain.models.StatusResult
import domain.usecase.ReplacementUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: ReplacementUseCase):ViewModel() {

    private var _replacement: MutableStateFlow<List<AutoParte>?> = MutableStateFlow(null)
    val replacement : MutableStateFlow<List<AutoParte>?> = _replacement

    init {
        onCreate()
    }
    fun onCreate() {
        viewModelScope.launch {
            fetchReplacement()
        }
    }
    suspend fun fetchReplacement() {

        when ( val result = useCase.invoke()){
            is StatusResult.Success -> _replacement.value = result.value
            is StatusResult.Error -> _replacement.value = null
            else -> {}
        }
    }
}