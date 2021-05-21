package com.ganesh.newsapp.news.api

import retrofit2.Response
import retrofit2.http.GET

/**
 * Describes endpoints to fetch the news from NewsAPI.
 *
 * Read the documentation [here](https://newsapi.org/docs/v2)
 */
interface NewsService {

    /**
     * Get top headlines.
     *
     * See [article documentation](https://newsapi.org/docs/endpoints/top-headlines).
     */
    @GET("top-headlines?apiKey=102a73f9d30b4a2a918b56efe368bd20&category=technology")
    suspend fun getTopHeadlines(): Response<NewsResponse>

}
