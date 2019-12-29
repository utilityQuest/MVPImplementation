package com.uq.mvpimplementation.News.Retrofit

import retrofit2.Retrofit

class RetrofitRepositoryImpl: RetrofitRepository<Retrofit> {
    private val  retrofitProvider: RetrofitProvider = RetrofitProvider()

    override fun get(): Retrofit? {
        return retrofitProvider.get()
    }

}