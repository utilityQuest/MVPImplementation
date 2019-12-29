package com.uq.mvpimplementation.News.Model

import com.google.gson.annotations.SerializedName

class RawInformation(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResult")
    val totalResult : String,
    @SerializedName("articles")
    val articles: List<NewsItemInformation>)