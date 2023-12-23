package eas.api_github_android.presentation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCase
import eas.api_github_android.network.statushandler.Resource
import kotlinx.coroutines.launch

@HiltViewModel
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