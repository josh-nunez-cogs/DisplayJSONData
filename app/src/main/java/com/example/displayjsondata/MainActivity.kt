package com.example.displayjsondata

import ArticleViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.displayjsondata.ui.theme.DisplayJSONDataTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayJSONDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val articleViewModel: ArticleViewModel by viewModel()

                    articleViewModel.getArticles();

                    ListArticles(articleViewModel)
                }
            }
        }
    }
}

@Composable
fun ListArticles(vm: ArticleViewModel) {
    val articles by vm.articles.observeAsState()
    LazyColumn {
        items(articles ?: emptyList()) { article ->
            DisplayArticle(article)
        }
    }
}

@Composable
fun DisplayArticle(article: Article) {
    Text(
        text = "Name: ${article.name}"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DisplayJSONDataTheme {
        ListArticles(
            ArticleViewModel(
                MockArticleRepository(
                    listOf(
                        Article("One", 1, 1.1, 11.11),
                        Article("Two", 2, 2.2, 22.22)
                    )
                )
            )
        )
    }
}