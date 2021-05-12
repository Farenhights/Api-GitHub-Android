package eas.api_github_android.network.statushandler

enum class ErrorStatus(val type: Int) {
    GENERIC(0),
    FROM_SERVICE(1),
    NO_NETWORK(2),
    TIMEOUT(3)
}