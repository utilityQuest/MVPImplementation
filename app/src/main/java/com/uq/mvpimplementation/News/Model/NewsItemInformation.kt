package com.uq.mvpimplementation.News.Model


class NewsItemInformation(
    val source: SourceOfNews?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)


/*class NewsItemInformation(
    @SerializedName("source")
    val source: SourceOfNews,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("urlToImage")
    val urlToImage:String,
    @SerializedName("publishedAt")
    val publishedAt:String,
    @SerializedName("content")
    val contentt:String
)*/
