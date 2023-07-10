package com.example.tigresquest.navigation

sealed class NavScreens(val route: String) {
    object InicioScreen : NavScreens("inicio_screen")
    object PreguntaScreen : NavScreens("pregunta_screen")

}
