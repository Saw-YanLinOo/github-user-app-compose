package com.agb.github_user_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.agb.github_user_app.presentation.navigation.SetUpNavGraph
import com.agb.github_user_app.ui.theme.GithubuserappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubuserappTheme {

                val navController = rememberNavController()

                SetUpNavGraph(
                    modifier = Modifier
                        .fillMaxSize(),
                    navController = navController,
                )
            }
        }
    }
}
