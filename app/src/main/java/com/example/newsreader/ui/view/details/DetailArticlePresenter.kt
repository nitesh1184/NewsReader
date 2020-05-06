package com.example.newsreader.ui.view.details

import com.example.newsreader.models.Article



class DetailArticlePresenter(private val detailArticleView: DetailArticleView) {

    fun loadDetailArticle(article: Article){
        detailArticleView.loadUrl(article.url)
    }
}
