package com.ganesh.newsapp.news

import com.ganesh.newsapp.news.storage.entity.NewsArticleDb

interface ItemClick {
    fun click(newsArticleDb: NewsArticleDb)
}