package com.agb.github_user_app.presentation.navigation

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import com.agb.github_user_app.R
import com.agb.github_user_app.ui.theme.LocalCustomColorsPalette
import kotlin.reflect.KClass

@Composable
fun BottomNavigation(modifier: Modifier = Modifier,navController: NavController) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val showNavBar by remember(backStackEntry){
        derivedStateOf {
            backStackEntry.hasAnyRoute(
                Screens.HomeScreen::class,
                Screens.ProfileScreen::class
            )
        }
    }

    if(!showNavBar) return

    BottomAppBar(
        containerColor = LocalCustomColorsPalette.current.bottomNavBarBg,
        ){
        BottomNavBarItem.entries.forEach { item->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedTextColor = LocalCustomColorsPalette.current.active,
                    selectedIconColor = LocalCustomColorsPalette.current.active
                ),
                selected = backStackEntry.isRouteSelected(item.route::class),
                onClick = {
                    Log.d("BottomNavigation", "BottomNavigation: ${navController.graph.startDestinationRoute}")
                    navController.graph.startDestinationRoute?.let {
                        navController.navigate(item.route) {
                            popUpTo(Screens.HomeScreen) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                },
                alwaysShowLabel = true,
                label = {
                    Text(item.title)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                    )
                }
            )
        }
    }

}

private fun NavBackStackEntry?.hasAnyRoute(vararg routes: KClass<*>): Boolean {
    return routes.any { this?.destination?.hasRoute(it) == true }
}

private fun NavBackStackEntry?.isRouteSelected(route: KClass<*>): Boolean {
    return this?.destination?.hasRoute(route) == true
}

enum class BottomNavBarItem(
    val route: Screens,
    @DrawableRes val icon: Int,
    val title: String
) {
     Home (
        route = Screens.HomeScreen,
        icon = R.drawable.ic_home,
        title = "Home"
    ),
     SearchItem(
        route = Screens.ProfileScreen,
        icon = R.drawable.ic_profile,
        title = "Profile"
    )

}