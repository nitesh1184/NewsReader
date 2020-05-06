package com.example.newsreader.ui.view.listartical

import android.content.res.Resources
import com.example.newsreader.R


class ArticleBySourcePresenter(private val articleBySourceView: ArticleBySourceView) {

    fun loadTabs(resources : Resources){
        val tabs = ArrayList<String>()
        val categories = resources.getStringArray(R.array.categories)

        tabs.add(resources.getString(R.string.headlines))
        for (i in categories.indices) {
            tabs.add(categories[i])
        }

        articleBySourceView.showTabs(tabs)
    }
}
