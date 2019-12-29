package com.uq.mvpimplementation.News

import com.uq.mvpimplementation.News.Model.RawInformation

interface NewsContract {
    interface View
    {
        fun showNewsSummary(rawInfo: RawInformation)
    }
    interface Presenter
    {
        fun getNews()
    }
}