package org.example.project.presentation.component.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import domain.models.AutoParte
import kotlinx.coroutines.flow.MutableStateFlow


@Composable
fun ListReplacement(homeViewModel: HomeViewModel) {

    val replacement = homeViewModel.replacement.collectAsState(initial = emptyList())
    val replacementList = replacement.value

    val replacement1 : AutoParte? = replacementList?.getOrNull(0)

    if (replacement1 != null) {
        Text(text = replacement1.titulo)
    } else {
        Text(text = "No hay datos")
    }
}