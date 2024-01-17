import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import eas.api_github_android.R
import eas.api_github_android.presentation.ui.components.RepositoryItem
import eas.api_github_android.presentation.ui.viewmodel.RepositoriesViewModel

@Composable
fun RepositoriesScreen(navController: NavController, viewModel: RepositoriesViewModel = hiltViewModel()) {

    val uiState by viewModel.uiRepositoriesState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getRepositories()
    }

    when {
        uiState.isLoading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }

        uiState.error.isNotEmpty() -> {
            Text(
                text = uiState.error, modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }

        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    itemsIndexed(uiState.repositories) { _, repository ->
                        RepositoryItem(
                            repositoryName = repository.name ?: "",
                            repositoryDescription = repository.description ?: "",
                            username = repository.owner?.login ?: "",
                            forkCount = repository.forks_count ?: 0,
                            starCount = repository.stargazers_count ?: 0,
                            avatarResId = repository.owner?.avatar_url ?: "",
                            navController = navController
                        )
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRepositoriesScreen() {
    val navController = rememberNavController()
    RepositoriesScreen(navController)
//    RepositoriesScreenMock()
}