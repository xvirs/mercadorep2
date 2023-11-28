package org.example.project.presentation.component.UI
import androidx.lifecycle.ViewModel
import domain.models.AutoParte
import domain.usecase.ReplacementUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel(val useCase: ReplacementUseCase):ViewModel() {

    var replacement: MutableStateFlow<AutoParte?> = MutableStateFlow(null)


}