package com.example.newsreader.networkdata

import android.net.Uri
import com.example.newsreader.BuildConfig


object TheNewsOrg {

  //  http://newsapi.org/v2/everything?q=bitcoin&from=2020-04-06&sortBy=publishedAt&apiKey=8efaee2f20094e6684d090860a946e80

    fun getEverything(sources: String? = "",
                      sortBy: String? = "publishedAt",
                      q: String? = "",
                      pageSize: Int? = 10,
                      pageNum: Int? = 1): String {
        return Uri.parse(BuildConfig.BASE_NEWS_API_URL).buildUpon()
                .appendPath("everything")
                .appendQueryParameter("sources", sources)
                .appendQueryParameter("sortBy", sortBy)
                .appendQueryParameter("q", q)
                .appendQueryParameter("pageSize", pageSize.toString())
                .appendQueryParameter("pageNum", pageNum.toString())
                .build()
                .toString()
    }

    fun getSources(): String {
        return Uri.parse(BuildConfig.BASE_NEWS_API_URL).buildUpon()
                .appendPath("sources")
                .appendQueryParameter("country", "in")
                .build()
                .toString()
    }
}
