package eas.api_github_android.extension

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import eas.api_github_android.R
import eas.api_github_android.network.RetrofitBuilder
import eas.api_github_android.network.statushandler.ErrorStatus
import eas.api_github_android.network.statushandler.Resource
import retrofit2.Response
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

inline fun <reified T> RetrofitBuilder.networkCall(block: RetrofitBuilder.() -> Response<T>): Resource<T> {
    val resource: Resource<T>

    resource = try {
        val response = block()

        if (response.isSuccessful) {
            Resource.success(response.body())
        } else {
            var errorResponse: String? = null

            response.errorBody()?.let { f ->
                errorResponse = f.string()
            }

            if (errorResponse.isNullOrEmpty()) {
                Resource.error(ErrorStatus.GENERIC, R.string.error_generic, null)
            } else {
                Resource.error(
                    ErrorStatus.FROM_SERVICE,
                    R.string.error_generic,
                    Gson().fromJson(errorResponse, T::class.java)
                )
            }
        }
    } catch (e: Exception) {
//        Crashlytics.logException(e)

        when (e) {
            is UnknownHostException -> {
                Resource.error(ErrorStatus.NO_NETWORK, R.string.no_connection, null)
            }
            is TimeoutException -> {
                Resource.error(ErrorStatus.TIMEOUT, R.string.error_timeout, null)
            }
            else -> Resource.error(ErrorStatus.GENERIC, R.string.error_generic, null)
        }
    }

    return resource
}

fun Context.isNetWorkConnected(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnected
}