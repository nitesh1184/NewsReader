package com.example.newsreader.ui.view.listchannel

import com.example.newsreader.models.Source


interface ListSourcesView {

    fun insertListSources(data: List<Source>?)
    fun loadingData(isNotFinished: Boolean)

}
