package com.example.newsreader.ui.view.listartical

import com.example.newsreader.models.Article


interface ListArticlesView {

    fun insertListArticles(data: List<Article>?)
    fun loadingData(isNotFinished: Boolean)

}
