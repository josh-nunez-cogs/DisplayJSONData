package com.example.displayjsondata

class MockArticleRepository(private val mockData: List<Article>): ArticleRepository  {
    override suspend fun getArticles(): List<Article> {
        return mockData
    }
}