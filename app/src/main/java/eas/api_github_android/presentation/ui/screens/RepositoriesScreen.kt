import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import eas.api_github_android.R
import eas.api_github_android.presentation.ui.components.RepositoryItem
import eas.api_github_android.presentation.ui.viewmodel.RepositoriesViewModel

@Composable
fun RepositoriesScreen(/*navController: NavController*/ viewModel: RepositoriesViewModel = hiltViewModel()) {

    val uiState by viewModel.uiRepositoriesState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getRepositories()
    }

    when {
        uiState.isLoading -> {
            // Mostrar indicador de carregamento
            uiState.toString()
        }
        uiState.error.isNotEmpty() -> {
            // Mostrar mensagem de erro
            // Exemplo:
            // Snackbar.make(binding.rootLayout, uiState.error, Snackbar.LENGTH_SHORT).show()
            uiState.toString()
        }
        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    itemsIndexed(uiState.repositories) { index, repository ->
                        RepositoryItem(
                            repositoryName = repository.name ?: "",
                            repositoryDescription = repository.description ?: "",
                            username = repository.owner?.login ?: "",
                            forkCount = repository.forks_count ?: 0,
                            starCount = repository.stargazers_count ?: 0,
                            avatarResId = R.drawable.ic_person // Replace with your actual avatar resource ID
                        )
                    }
                }
            )
        }
    }

    /*Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RepositoryItem(
            repositoryName = "My Awesome Repo",
            repositoryDescription = "This is a description of my repository.",
            username = "john_doe",
            forkCount = 100,
            starCount = 50,
            avatarResId = R.drawable.ic_person
        )

        RepositoryItem(
            repositoryName = "My Awesome Repo",
            repositoryDescription = "This is a description of my repository.",
            username = "john_doe",
            forkCount = 100,
            starCount = 50,
            avatarResId = R.drawable.ic_person // Replace with your actual avatar resource ID
        )
    }*/
}

@Preview
@Composable
fun PreviewRepositoriesScreen() {
    RepositoriesScreen()
}