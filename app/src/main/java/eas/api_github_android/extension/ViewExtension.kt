package eas.api_github_android.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import eas.api_github_android.network.statushandler.Resource
import eas.api_github_android.network.statushandler.Status

inline fun <T> LiveData<Resource<T>>.observeResourceResponse(
    owner: LifecycleOwner,
    crossinline onSuccess: (Resource<T?>) -> Unit = {},
    crossinline onError: (Resource<T?>) -> Unit = {},
    crossinline onLoading: (Resource<T?>) -> Unit = {}
) {
    this.observe(owner, Observer<Resource<T>> {
        when (it.status) {
            is Status.Loading -> {
                onLoading.invoke(it)
            }
            is Status.Success -> {
                onSuccess.invoke(it)
            }
            is Status.Error -> {
                onError.invoke(it)
            }
        }
    })
}