package eas.api_github_android.presentation.ui.navigation

sealed class AppScreens(val route: String) {
    object RepositoryScreen: AppScreens("repository_screen")
    object ItemRepositoryScreen: AppScreens("item_repository_screen")
}
