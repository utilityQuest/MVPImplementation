package com.uq.mvpimplementation.News.Retrofit

interface RetrofitRepository<T> {
    fun get(): T?
}