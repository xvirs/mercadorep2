package org.example.project.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinos(
    val icon : ImageVector?,
    val title : String,
){
    object Pantalla1: Destinos( Icons.Filled.AccountBox, "Pantalla1")
    object Pantalla2: Destinos(Icons.Filled.AddCircle, "Pantalla2")
    object Pantalla3: Destinos(Icons.Filled.Build, "Pantalla3")
    object Pantalla4: Destinos(Icons.Filled.DateRange, "Pantalla4")
    object Pantalla5: Destinos(Icons.Filled.Face, "Pantalla5")
}
