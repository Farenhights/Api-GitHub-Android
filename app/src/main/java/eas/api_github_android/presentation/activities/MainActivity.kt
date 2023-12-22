package eas.api_github_android.presentation.activities

import RepositoriesScreen
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
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
        RepositoriesScreen()
    }
}

@Composable
@Preview(showSystemUi = true)
fun AppPreview() {
    App()
}