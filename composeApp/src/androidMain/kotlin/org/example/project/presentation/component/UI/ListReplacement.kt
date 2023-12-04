package org.example.project.presentation.component.UI

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel


@Composable
fun ListReplacement(homeViewModel: HomeViewModel = koinViewModel()) {

//    val replacement = homeViewModel.replacement.collectAsState(initial = emptyList())
//    val replacementList = replacement.value

//    val replacement1 : AutoParte? = replacementList?.getOrNull(0)

//    if (replacement1 != null) {
//        Text(text = replacement1.titulo)
//    } else {
//        Text(text = "No hay datos")
//    }
}