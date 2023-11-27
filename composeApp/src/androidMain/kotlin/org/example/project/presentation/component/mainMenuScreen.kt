package org.example.project.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.example.project.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun firstScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigationItemViews = listOf(
        Destinos.Pantalla1,
        Destinos.Pantalla2,
        Destinos.Pantalla3,
        Destinos.Pantalla4,
        Destinos.Pantalla5
    )

    Scaffold (
        scaffoldState = scaffoldState,
        topBar = {TopBar(scope, scaffoldState)},
        drawerContent = { Drawer(menu_items = navigationItemViews) }
    ){

    }
}

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    TopAppBar(
        title = { Text(text = "Compose") },
        navigationIcon  = {
            IconButton(onClick = {
                scope.launch { scaffoldState.drawerState.open()}
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "Icono de menu")
            }
        },
    )
}

@Composable
fun Drawer(menu_items: List<Destinos>) {

    Column {
        Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.ic_launcher_foreground),
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Cyan),
            contentDescription = "Menu de opciones",
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 16.dp)
            .clip(MaterialTheme.shapes.small)
            .padding(8.dp),
        contentScale = ContentScale.Crop )

        Spacer(modifier = Modifier.fillMaxWidth().height(15.dp))

        menu_items.forEach { item ->
            DrawerItem(item = item)
        }
    }
}

@Composable
fun DrawerItem(item: Destinos) {
    Row (modifier =
    Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(horizontal = 16.dp)
        .clip(MaterialTheme.shapes.small)
        .padding(8.dp)
        .clickable {

        }
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title
        )
        Text(text = item.title, style = MaterialTheme.typography.body1)

    }
}

