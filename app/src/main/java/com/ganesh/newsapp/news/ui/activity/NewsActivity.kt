package com.ganesh.newsapp.news.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ganesh.newsapp.core.ui.ViewState
import com.ganesh.newsapp.core.ui.base.BaseActivity
import com.ganesh.newsapp.core.utils.observeNotNull
import com.ganesh.newsapp.core.utils.toast
import com.ganesh.newsapp.databinding.ActivityMainBinding
import com.ganesh.newsapp.news.ItemClick
import com.ganesh.newsapp.news.storage.entity.NewsArticleDb
import com.ganesh.newsapp.news.ui.adapter.NewsArticlesAdapter
import com.ganesh.newsapp.news.ui.viewmodel.NewsArticleViewModel


class NewsActivity : BaseActivity(),ItemClick {

    private val newsArticleViewModel: NewsArticleViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    lateinit var itemClick: ItemClick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemClick = this
        // Setting up RecyclerView and adapter
        binding.newsList.setEmptyView(binding.emptyLayout.emptyView)
        binding.newsList.setProgressView(binding.progressLayout.progressView)



        // Update the UI on state change
        newsArticleViewModel.getNewsArticles().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> {
                    val adapter = NewsArticlesAdapter(state.data,itemClick,this)
                    binding.newsList.adapter = adapter
                    binding.newsList.layoutManager = LinearLayoutManager(this)
                }
                is ViewState.Loading -> binding.newsList.showLoading()
                is ViewState.Error -> toast("Something went wrong ¯\\_(ツ)_/¯ => ${state.message}")
            }
        }

    }

    override fun click(newsArticleDb: NewsArticleDb) {
        val intent = Intent(this,NewDetailsActivity::class.java)
        intent.putExtra("author",newsArticleDb.author)
        intent.putExtra("title",newsArticleDb.title)
        intent.putExtra("urlToImage",newsArticleDb.urlToImage)
        intent.putExtra("publishedAt",newsArticleDb.publishedAt)
        startActivity(intent)
    }
}
