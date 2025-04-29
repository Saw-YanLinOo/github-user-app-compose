package com.agb.github_user_app.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.agb.github_user_app.presentation.navigation.Screens


fun NavGraphBuilder.detailScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable<Screens.DetailScreen> {
        DetailScreen()
    }
}

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Detail Screen",
            modifier = modifier
        )
    }
}