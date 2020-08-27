package com.messiasjunior.digiointerfaceclone.util

class Resource<out T> private constructor(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val throwable: Throwable? = null
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    fun isLoading() = status == Status.LOADING
    fun isError() = status == Status.ERROR
    fun isSuccess() = status == Status.SUCCESS

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(
                status = Status.SUCCESS,
                data = data
            )
        }

        fun <T> error(msg: String? = null, data: T? = null, throwable: Throwable?): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                msg,
                throwable
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data
            )
        }
    }
}
