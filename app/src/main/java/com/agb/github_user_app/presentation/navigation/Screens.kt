package com.agb.github_user_app.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens(){

    @Serializable
    object  OnBoardingScreen: Screens()

    @Serializable
    object HomeScreen: Screens()

    @Serializable
    data class DetailScreen(val id:Int): Screens()

    @Serializable
    object ProfileScreen : Screens()

}