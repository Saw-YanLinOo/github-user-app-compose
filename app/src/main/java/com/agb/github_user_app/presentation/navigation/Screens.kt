package com.agb.github_user_app.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens(){

    @Serializable
    object  OnBoardingScreen: Screens()

    @Serializable
    object HomeScreen: Screens()

    @Serializable
    object DetailScreen: Screens()

    @Serializable
    object ProfileScreen : Screens()
}