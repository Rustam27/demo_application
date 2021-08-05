package ru.test.app.base

data class DataWrapper<T>(
    val status: Status,
    val data: T? = null,
) {

    companion object {
        inline fun <reified T> loading(): DataWrapper<T> {
            return DataWrapper(status = Status.Loading)
        }

        inline fun <reified T> error(throwable: Throwable?): DataWrapper<T> {
            return DataWrapper(status = Status.Error(throwable))
        }

        inline fun <reified T> success(data: T): DataWrapper<T> {
            return DataWrapper(status = Status.Success, data = data)
        }
    }
}

sealed class Status {

    object Loading : Status()

    object Success : Status()

    data class Error(val throwable: Throwable?) : Status()
}
