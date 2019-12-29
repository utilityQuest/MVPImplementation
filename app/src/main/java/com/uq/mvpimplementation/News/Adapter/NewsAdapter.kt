package com.uq.mvpimplementation.News.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.uq.mvpimplementation.News.Model.NewsItemInformation
import com.uq.mvpimplementation.R
import kotlinx.android.synthetic.main.news_item_view.view.*

class NewsAdapter(context: Context, newsItem: ArrayList<NewsItemInformation>) :
    ArrayAdapter<NewsItemInformation>(context, 0, newsItem) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView: View = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.news_item_view,
            parent,
            false
        )

        var currentNewsItem: NewsItemInformation? = getItem(position)
        listItemView.title.text = currentNewsItem?.title
        listItemView.description.text = currentNewsItem?.description
        return listItemView
    }
}