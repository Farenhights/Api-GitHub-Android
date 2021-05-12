package eas.api_github_android.network.statushandler

sealed class Status {
    object Success : Status()
    class Error(val errorStatus: ErrorStatus?) : Status()
    object Loading : Status()
}