package eas.api_github_android.presentation.ui.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import coil.ImageLoader
import coil.request.ImageRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class RepositoryDetailViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {

    suspend fun getImageRepository(): Drawable? {
        val imageLoader = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data("https://avatars.githubusercontent.com/u/6764390?v=4")
            .build()
        return imageLoader.execute(request).drawable
    }
}