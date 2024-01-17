package eas.api_github_android.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eas.api_github_android.presentation.ui.screens.RepositoryDetailScreen

object Destinations {
    const val REPOSITORIES_SCREEN = "repositoriesScreen"
    const val REPOSITORY_DETAIL_SCREEN = "repositoryDetailScreen"
}

@Composable
fun NavGraph(startDestination: String = Destinations.REPOSITORIES_SCREEN) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Destinations.REPOSITORY_DETAIL_SCREEN) { backStackEntry ->
            val repositoryName = backStackEntry.arguments?.getString("repositoryName")
            val repositoryDescription = backStackEntry.arguments?.getString("repositoryDescription")
            val userName = backStackEntry.arguments?.getString("userName")
            val forkCount = backStackEntry.arguments?.getInt("forkCount")
            val starCount = backStackEntry.arguments?.getInt("starCount")
            val avatarResId = backStackEntry.arguments?.getString("avatarResId")

            RepositoryDetailScreen(repositoryName, repositoryDescription, userName, forkCount, starCount, avatarResId)
        }
    }
}