package eas.api_github_android.presentation.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCase
import eas.api_github_android.network.statushandler.Resource
import eas.api_github_android.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class RepositoriesViewModel(
    private val repositoriesUseCase: RepositoriesUseCase
) : BaseViewModel() {

    var repositoriesLiveData = MutableLiveData<Resource<RepositoriesResponse>>()

    fun getRepositories() {
        loadingStateLiveData.postValue(true)
        viewModelScope.launch {
            repositoriesLiveData.postValue(repositoriesUseCase.invoke())
            loadingStateLiveData.postValue(false)
        }
    }
}