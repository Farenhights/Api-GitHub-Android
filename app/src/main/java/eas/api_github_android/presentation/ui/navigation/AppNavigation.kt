package eas.api_github_android.presentation.ui.navigation

import RepositoriesScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.RepositoryScreen.route) {
        composable(route = AppScreens.RepositoryScreen.route) {
            RepositoriesScreen()
        }
       /* composable(route = AppScreens.ItemRepositoryScreen.route) {
            ItemRepositoryScreen()
        }*/
    }
}