package eas.api_github_android.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eas.api_github_android.R
import eas.api_github_android.data.model.repositories.common.ItemsItem
import eas.api_github_android.data.model.repositories.common.Owner
import eas.api_github_android.presentation.ui.components.RepositoryItem

@Composable
fun RepositoriesScreenMock() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {

            val repositories = listOf<ItemsItem>(
                ItemsItem(
                    name = "Sample Repo",
                    description = "This is a sample repository",
                    owner = Owner(login = "sample_user"),
                    forks_count = 10,
                    stargazers_count = 50
                    // Add other necessary fields with mock data
                ),

                ItemsItem(
                    name = "Sample Repo",
                    description = "This is a sample repository",
                    owner = Owner(login = "sample_user"),
                    forks_count = 10,
                    stargazers_count = 50
                    // Add other necessary fields with mock data
                )
            )

            itemsIndexed(repositories) {_, repository ->
                RepositoryItem(
                    repositoryName = repository.name ?: "",
                    repositoryDescription = repository.description ?: "",
                    username = repository.owner?.login ?: "",
                    forkCount = repository.forks_count ?: 0,
                    starCount = repository.stargazers_count ?: 0,
                    avatarResId = R.drawable.ic_person
                )
            }
        }
    )
}

@Preview
@Composable
fun RepositoriesScreenMockPreview() {
    RepositoriesScreenMock()
}