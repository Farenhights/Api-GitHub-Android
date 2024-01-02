package eas.api_github_android.presentation.activities

import RepositoriesScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import eas.api_github_android.application.App

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        RepositoriesScreen(navController)
    }
}

@Composable
@Preview(showSystemUi = true)
fun AppPreview() {
    App()
}