package com.uq.mvpimplementation.News.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class RetrofitProvider {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://newsapi.org/"
    private val gson = GsonConverterFactory.create()
    private val logging: HttpLoggingInterceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gson)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return retrofit
    }

    fun get(): Retrofit? {
        return getRetrofitInstance()
    }
}