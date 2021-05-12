package eas.api_github_android.data

import eas.api_github_android.network.RetrofitBuilder
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class BaseRepository : KoinComponent {
    val builder: RetrofitBuilder by inject()
}