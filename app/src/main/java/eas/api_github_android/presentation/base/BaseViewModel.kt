package eas.api_github_android.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {

    var loadingStateLiveData = MutableLiveData<Boolean>()
}