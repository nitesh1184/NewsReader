package com.example.newsreader.ui.view.listartical

import com.example.newsreader.models.GetArticles
import com.example.newsreader.networkdata.ApiRepository
import com.example.newsreader.networkdata.TheNewsOrg
import com.example.newsreader.ui.view.listartical.ListArticlesView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class ListArticlesPresenter(private val listArticlesView: ListArticlesView) {

    fun getArticlesByCategory(source: String?, category: String) {
        listArticlesView.loadingData(true)
        doAsync {
            val data = ApiRepository<GetArticles>().requestGet(
                    TheNewsOrg.getEverything(q = category, sources =  source), GetArticles::class.java)

            uiThread {
                if(data?.status.equals("ok")){
                    listArticlesView.insertListArticles(data?.articles)
                }
                listArticlesView.loadingData(false)
            }
        }
    }
}
