package com.example.tigresquest.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tigresquest.R
import com.example.tigresquest.navigation.NavScreens


@Composable
fun InicioScreen(navController: NavController) {
    Scaffold(

        content = { InicioContent(navController) }


    )
}


@Composable
fun InicioContent(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dorado))
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                painter = painterResource(id = R.drawable.tigres_logo), contentDescription = "Logo"
            )

            Button(
                onClick = {
                    navController.navigate(route = NavScreens.PreguntaScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.azul)),

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Text(text = "Iniciar Preguntas", color = colorResource(id = R.color.dorado))
            }
        }
    }
}

