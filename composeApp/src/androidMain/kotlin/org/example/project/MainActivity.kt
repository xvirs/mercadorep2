package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import org.example.project.presentation.component.UI.HomeViewModel
import org.example.project.presentation.component.UI.ListReplacement
import org.example.project.presentation.component.firstScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                firstScreen()
                ListReplacement(viewModel)
            }

        }
    }
}
