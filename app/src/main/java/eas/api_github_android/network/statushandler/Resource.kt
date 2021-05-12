package eas.api_github_android.network.statushandler

data class Resource<out T>(val status: Status, val data: T?, val message: Int = -1) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.Success,
                data,
                -1
            )
        }

        fun <T> error(errorStatus: ErrorStatus? = null, msg: Int, data: T?): Resource<T> {
            errorStatus?.let {
//                Crashlytics.log("eas.api_github_android.network.statushandler.ErrorStatus: ${it.type}")
            }
            return Resource(
                Status.Error(errorStatus),
                data,
                msg
            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(
                Status.Loading,
                data,
                -1
            )
        }
    }
}