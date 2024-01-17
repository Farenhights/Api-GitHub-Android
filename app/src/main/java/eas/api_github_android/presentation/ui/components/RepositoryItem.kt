package eas.api_github_android.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import eas.api_github_android.R
import eas.api_github_android.data.model.repositories.common.ItemsItem
import eas.api_github_android.presentation.ui.navigation.Destinations
import okio.ByteString.Companion.encodeUtf8
import java.net.URLEncoder

@Composable
fun RepositoryItem(
    repositoryName: String,
    repositoryDescription: String,
    username: String,
    forkCount: Int,
    starCount: Int,
    avatarResId: String,
    navController: NavController? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                val urlEncoded = URLEncoder.encode(avatarResId, "UTF-8")
                navController?.navigate("${Destinations.REPOSITORY_DETAIL_SCREEN}/$repositoryName/$repositoryDescription/$username/$forkCount/$starCount/$urlEncoded")
            }
    ) {
        // Avatar Image
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(avatarResId)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_person),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Repository Info Column
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = repositoryName,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = repositoryDescription,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // User Info Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // User Name
                Text(
                    text = "@$username",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                // Fork Image
                Image(
                    painter = painterResource(R.drawable.ic_fork),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = forkCount.toString(),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = 4.dp)
                )

                // Star Image
                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = starCount.toString(),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewItemRepository() {
    RepositoryItem(
        repositoryName = "My Awesome Repo",
        repositoryDescription = "This is a description of my repository.",
        username = "john_doe",
        forkCount = 100,
        starCount = 50,
        avatarResId = "" // Replace with your actual avatar resource ID
    )
}