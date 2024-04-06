package com.example.displayjsondata

import ArticleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ArticleRepository> { ArticleAssetRepository(androidContext()) }
    viewModel { ArticleViewModel(get()) }
}
