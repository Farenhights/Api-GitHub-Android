package eas.api_github_android.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
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
    private val repositoriesUseCase: RepositoriesUseCase
) : ViewModel() {

    private val _uiRepositoriesState = MutableStateFlow(RepositoriesState())
    val uiRepositoriesState: StateFlow<RepositoriesState> = _uiRepositoriesState.asStateFlow()

    fun getRepositories() {
        viewModelScope.launch {
            // Atualiza o estado para indicar que a requisição está em andamento
            _uiRepositoriesState.value = _uiRepositoriesState.value.copy(isLoading = true)

            // Realiza a requisição e atualiza o estado com base no resultado
            val result = repositoriesUseCase.invoke()
            _uiRepositoriesState.value = _uiRepositoriesState.value.copy(
                isLoading = false,
                repositories = result.data?.items ?: arrayListOf()
            )
        }
    }
}