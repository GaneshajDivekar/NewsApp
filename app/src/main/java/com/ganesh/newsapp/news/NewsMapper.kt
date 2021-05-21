package com.ganesh.newsapp.news

import com.ganesh.newsapp.core.mapper.Mapper
import com.ganesh.newsapp.news.api.NewsArticle
import com.ganesh.newsapp.news.storage.entity.NewsArticleDb

interface NewsMapper : Mapper<NewsArticleDb, NewsArticle> {
    override fun NewsArticleDb.toRemote(): NewsArticle {
        return NewsArticle(
            author = author,
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt,
            content = content,
            source = NewsArticle.Source(source.id, source.name)
        )
    }

    override fun NewsArticle.toStorage(): NewsArticleDb {
        return NewsArticleDb(
            author = author,
            title = title,
            description = description,
            url = url,
            urlToImage = urlToImage,
            publishedAt = publishedAt,
            content = content,
            source = NewsArticleDb.Source(source.id, source.name)
        )
    }
}