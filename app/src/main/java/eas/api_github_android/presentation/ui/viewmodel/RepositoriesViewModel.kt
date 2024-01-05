package eas.api_github_android.presentation.ui.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCase
import eas.api_github_android.presentation.ui.state.RepositoriesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    application: Application,
    private val repositoriesUseCase: RepositoriesUseCase
) : BaseViewModel(application) {

    private val _uiRepositoriesState = MutableStateFlow(RepositoriesState())
    val uiRepositoriesState: StateFlow<RepositoriesState> = _uiRepositoriesState.asStateFlow()

    fun getRepositories() {
        viewModelScope.launch {
            _uiRepositoriesState.value = _uiRepositoriesState.value.copy(isLoading = true)

            val result = repositoriesUseCase.invoke()
            _uiRepositoriesState.value = _uiRepositoriesState.value.copy(
                isLoading = false,
                repositories = result.data?.items ?: arrayListOf()
            )
        }
    }
}