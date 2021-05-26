package eas.api_github_android.presentation.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCase
import eas.api_github_android.network.statushandler.Resource
import kotlinx.coroutines.launch

class RepositoriesViewModel(
    private val repositoriesUseCase: RepositoriesUseCase
) : ViewModel() {

    var repositoriesLiveData = MutableLiveData<Resource<RepositoriesResponse>>()

    fun getRepositories() {
//        loadingStateLiveData.postValue(true)
        viewModelScope.launch {
            repositoriesLiveData.postValue(repositoriesUseCase.invoke())
        }
    }
}