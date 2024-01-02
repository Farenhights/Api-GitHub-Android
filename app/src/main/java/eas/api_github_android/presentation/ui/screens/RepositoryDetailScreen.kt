package eas.api_github_android.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eas.api_github_android.data.model.repositories.common.ItemsItem

@Composable
fun RepositoryDetailScreen(
    repositoryName: String,
    repositoryDescription: String,
    username: String,
    forkCount: Int,
    starCount: Int
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Repository Name: $repositoryName")
        Text(text = "Description: $repositoryDescription")
        Text(text = "Username: $username")
        Text(text = "Forks: $forkCount")
        Text(text = "Stars: $starCount")
    }
}
