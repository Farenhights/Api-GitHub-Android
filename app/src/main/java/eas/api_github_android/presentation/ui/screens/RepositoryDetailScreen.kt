package eas.api_github_android.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import eas.api_github_android.R
import eas.api_github_android.presentation.ui.viewmodel.RepositoryDetailViewModel

@Composable
fun RepositoryDetailScreen(
    repositoryName: String?,
    repositoryDescription: String?,
    username: String?,
    forkCount: Int?,
    starCount: Int?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        val imageModifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .size(200.dp)

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://avatars.githubusercontent.com/u/6764390?v=4")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_person),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = imageModifier
        )
        Text(text = "Repository Name: $repositoryName")
        Text(text = "Description: $repositoryDescription")
        Text(text = "Username: $username")
        Text(text = "Forks: $forkCount")
        Text(text = "Stars: $starCount")
    }
}

@Preview(showSystemUi = true)
@Composable
fun RepositoryDetailScreenPreview() {
    RepositoryDetailScreen(
        LoremIpsum().values.first().take(10), LoremIpsum().values.first().take(32),
        LoremIpsum().values.first().take(10),
        1200, 550
    )
}