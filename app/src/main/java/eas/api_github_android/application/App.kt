package eas.api_github_android.application

import RepositoriesScreen
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import eas.api_github_android.presentation.ui.screens.RepositoryDetailScreen

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "repositoriesScreen"
        ) {
            composable("repositoriesScreen") {
                RepositoriesScreen(navController)
            }
            composable(
                route = "repositoryDetailScreen/{repositoryName}/{repositoryDescription}/{username}/{forkCount}/{starCount}/{avatarResId}",
                arguments = listOf(
                    navArgument("repositoryName") { type = NavType.StringType },
                    navArgument("repositoryDescription") { type = NavType.StringType },
                    navArgument("username") { type = NavType.StringType },
                    navArgument("forkCount") { type = NavType.IntType },
                    navArgument("starCount") { type = NavType.IntType },
                    navArgument("avatarResId") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val repositoryName = backStackEntry.arguments?.getString("repositoryName") ?: ""
                val repositoryDescription = backStackEntry.arguments?.getString("repositoryDescription") ?: ""
                val username = backStackEntry.arguments?.getString("username") ?: ""
                val forkCount = backStackEntry.arguments?.getInt("forkCount") ?: 0
                val starCount = backStackEntry.arguments?.getInt("starCount") ?: 0
                val avatarResId = backStackEntry.arguments?.getString("avatarResId") ?: ""

                RepositoryDetailScreen(
                    repositoryName = repositoryName,
                    repositoryDescription = repositoryDescription,
                    username = username,
                    forkCount = forkCount,
                    starCount = starCount,
                    avatarResId = avatarResId
                )
            }
        }
    }
}

