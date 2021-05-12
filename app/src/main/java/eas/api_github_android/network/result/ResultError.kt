package eas.api_github_android.network.result

sealed class ResultError(val message: String?) {
    class NetworkError(
        val httpCode: Int = -1,
        val httpMessage: String? = null,
        val title: String? = null,
        val description: String? = null,
        val imageURL: String? = null,
        val buttonText: String? = null,
        val exceptionTitle: String? = null,
        val exceptionMessage: String? = null,
        val isConnectionError: Boolean = false,
        val closeScreen: Boolean? = false
    ) : ResultError(httpMessage) {
        fun httpCodeIs412() = httpCode == 412
    }

    class UnavailableNetworkConnectionError : ResultError("Connection unavailable")
    class UnauthorizedError : ResultError("User not authorized")
    class UnknownError : ResultError("Unknown error")
    class DatabaseError : ResultError("Database error")
    class FileParseError : ResultError("File parse error")
    class InvalidFieldsError(val fieldIds: List<String>) : ResultError("Invalid fields ($fieldIds)")
}