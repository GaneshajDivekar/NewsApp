package com.ganesh.newsapp.news.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ganesh.newsapp.core.ui.ViewState
import com.ganesh.newsapp.news.domain.NewsRepository
import com.ganesh.newsapp.news.storage.entity.NewsArticleDb

/**
 * A container for [NewsArticleDb] related data to show on the UI.
 */
class NewsArticleViewModel @ViewModelInject constructor(
        newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticleDb: LiveData<ViewState<List<NewsArticleDb>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<NewsArticleDb>>> = newsArticleDb
}