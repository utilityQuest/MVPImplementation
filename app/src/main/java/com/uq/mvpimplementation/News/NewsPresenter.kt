package com.uq.mvpimplementation.News

import android.util.Log
import com.uq.mvpimplementation.News.Retrofit.NewsApi
import com.uq.mvpimplementation.News.Retrofit.RetrofitRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class NewsPresenter(val view: NewsContract.View) : NewsContract.Presenter {
    private val retrofitRepositoryImpl: Retrofit? = RetrofitRepositoryImpl()
        .get()

    override fun getNews() {
        if (retrofitRepositoryImpl != null) {
            retrofitRepositoryImpl.create(NewsApi::class.java).
                getNews().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).doOnSubscribe {
                    Log.v("doOnSubscribe", "Executing do on Subscribe")
                }
                .subscribe({
                    view?.showNewsSummary(it)
                },{
                    Log.d("Error", it.message)
                })
        }
    }
}