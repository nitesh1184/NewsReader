package com.example.newsreader.models

import com.google.gson.annotations.SerializedName

data class GetArticles(
        @SerializedName("status") val status: String?,
        @SerializedName("totalResults") val totalResults: Int?,
        @SerializedName("articles") val articles: List<Article>?
)
