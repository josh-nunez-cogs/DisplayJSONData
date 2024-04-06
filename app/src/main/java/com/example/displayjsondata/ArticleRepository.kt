package com.example.displayjsondata

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}