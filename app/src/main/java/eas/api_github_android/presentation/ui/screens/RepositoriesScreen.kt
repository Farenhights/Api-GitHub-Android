import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import eas.api_github_android.R
import eas.api_github_android.presentation.ui.components.RepositoryItem
import eas.api_github_android.presentation.ui.screens.RepositoriesScreenMock
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
                    itemsIndexed(uiState.repositories) { _, repository ->
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
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewRepositoriesScreen() {
//    RepositoriesScreen()
    RepositoriesScreenMock()
}