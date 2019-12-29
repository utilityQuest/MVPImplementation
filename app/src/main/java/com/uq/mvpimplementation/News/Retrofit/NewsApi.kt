package com.uq.mvpimplementation.News.Retrofit

import com.uq.mvpimplementation.News.Model.RawInformation
import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi {
    @GET("v2/top-headlines?country=in&apiKey=1da5b5cdf42e4e26be6831841a5c1cd3")
    fun getNews(): Single<RawInformation>
}