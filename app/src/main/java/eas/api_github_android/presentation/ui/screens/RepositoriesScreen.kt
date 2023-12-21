import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eas.api_github_android.R
import eas.api_github_android.presentation.ui.components.RepositoryItem

@Composable
fun RepositoriesScreen(/*navController: NavController*/) {

    Column(
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
    }
}

@Preview
@Composable
fun PreviewRepositoriesScreen() {
    RepositoriesScreen()
}