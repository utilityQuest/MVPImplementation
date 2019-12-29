package com.uq.mvpimplementation.News

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uq.mvpimplementation.News.Adapter.NewsAdapter
import com.uq.mvpimplementation.News.Model.NewsItemInformation
import com.uq.mvpimplementation.News.Model.RawInformation

import com.uq.mvpimplementation.R
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment(), NewsContract.View {
    lateinit var presenter: NewsContract.Presenter
    lateinit var usableContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        usableContext = container!!.context
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = NewsPresenter(this)
    }
    override fun showNewsSummary(rawApiInformation: RawInformation) {
        var newsList: ArrayList<NewsItemInformation> = ArrayList()
        for (item in rawApiInformation.articles)
            newsList.add(
                NewsItemInformation(
                    item.source,
                    item.author,
                    item.title,
                    item.description,
                    item.url,
                    item.urlToImage,
                    item.publishedAt,
                    item.content
                )
            )

        val itemAdapter = NewsAdapter(usableContext, newsList)
        news_list.adapter = itemAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getNews()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NewsFragment().apply {
                return this
            }
    }
}
