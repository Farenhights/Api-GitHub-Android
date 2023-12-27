package eas.api_github_android.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import eas.api_github_android.presentation.ui.state.RepositoriesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeRepositoriesViewModel(private val fakeState: RepositoriesState) : ViewModel() {
    private val _uiRepositoriesState = MutableStateFlow(fakeState)
    val uiRepositoriesState: StateFlow<RepositoriesState> = _uiRepositoriesState.asStateFlow()

    // You can leave getRepositories() empty or create a mock function if needed for preview
    fun getRepositories() {
        // Implement if necessary for preview
    }
}