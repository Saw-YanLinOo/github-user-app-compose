package com.agb.github_user_app.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.agb.github_user_app.presentation.detail.detailScreen
import com.agb.github_user_app.presentation.home.HomeScreen
import com.agb.github_user_app.presentation.home.homeScreen
import com.agb.github_user_app.presentation.onboarding.OnBoardingScreen
import com.agb.github_user_app.presentation.onboarding.onBoardingScree
import com.agb.github_user_app.presentation.profile.profileScreen


@Composable
fun SetUpNavGraph(modifier: Modifier,navController: NavHostController, startDestination: Any= Screens.OnBoardingScreen) {
    Scaffold(

        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
                .padding(bottom = innerPadding.calculateBottomPadding())
        ){
            onBoardingScree(navController = navController)
            homeScreen(navController= navController)
            detailScreen(navController=navController)
            profileScreen(navController=navController)
        }
    }
}