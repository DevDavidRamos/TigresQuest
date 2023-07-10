package com.example.tigresquest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tigresquest.presentation.InicioScreen
import com.example.tigresquest.presentation.PreguntaScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination = NavScreens.InicioScreen.route){
    composable(route = NavScreens.InicioScreen.route){
        InicioScreen(navController)
    }

    composable(route = NavScreens.PreguntaScreen.route){
       PreguntaScreen(navController)
    }
}
}