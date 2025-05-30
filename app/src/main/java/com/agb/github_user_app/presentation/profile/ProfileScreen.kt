package com.agb.github_user_app.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.agb.github_user_app.presentation.navigation.Screens
import com.agb.github_user_app.ui.theme.LocalCustomColorsPalette


fun NavGraphBuilder.profileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable<Screens.ProfileScreen> {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier=modifier
                .fillMaxSize()
                .background(LocalCustomColorsPalette.current.mobileBackground)
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            Text(
                text = "Profile Screen",
                modifier = modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}