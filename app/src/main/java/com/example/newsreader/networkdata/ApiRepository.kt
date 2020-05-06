package com.example.newsreader.networkdata

import android.util.Log
import com.example.newsreader.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request


class ApiRepository<T> {

    fun requestGet(url: String, c: Class<T>): T? {
        Log.i("wew", "get_request -> " + url)
        val client = OkHttpClient()
        val request = Request.Builder().url(url)
            .addHeader("X-Api-Key", BuildConfig.NEWS_API_KEY).build()
        val response = client.newCall(request).execute()
        Log.e("respone","response"+response)

        return Gson().fromJson(response.body()?.string(), c)
    }


}
