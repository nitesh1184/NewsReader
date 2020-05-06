package com.example.newsreader.ui.view.listchannel

import android.util.Log
import com.example.newsreader.models.GetSources
import com.example.newsreader.networkdata.ApiRepository
import com.example.newsreader.networkdata.TheNewsOrg
import com.example.newsreader.ui.view.listchannel.ListSourcesView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class ListSourcesPresenter(private val listSourcesView: ListSourcesView) {

    fun getSources() {
        listSourcesView.loadingData(true)
        doAsync {
            val data = ApiRepository<GetSources>().requestGet(
                    TheNewsOrg.getSources(), GetSources::class.java)
            Log.e("hahhahaah","kskjskjs"+ TheNewsOrg.getSources())


            uiThread {
                if (data?.status.equals("ok")) {
                    listSourcesView.insertListSources(data?.sources)
                }
                listSourcesView.loadingData(false)
            }
        }
    }


}
