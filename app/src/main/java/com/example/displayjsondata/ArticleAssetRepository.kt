package com.example.displayjsondata

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import com.google.gson.Gson

class ArticleAssetRepository(private val context: Context): ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return withContext(Dispatchers.IO) {
            try {
                val json = context.assets.open("articles.json").bufferedReader().use { it.readText() }
                val gson = Gson()
                gson.fromJson(json, Array<Article>::class.java).toList()
            } catch (e: IOException) {
                // Handle error (e.g., log, throw custom exception)
                emptyList()
            }
        }
    }
}