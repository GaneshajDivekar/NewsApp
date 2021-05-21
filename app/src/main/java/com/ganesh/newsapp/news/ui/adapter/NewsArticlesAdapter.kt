package com.ganesh.newsapp.news.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ganesh.newsapp.R
import com.ganesh.newsapp.news.storage.entity.NewsArticleDb
import com.ganesh.newsapp.databinding.RowNewsArticleBinding
import com.ganesh.newsapp.news.ItemClick

/**
 * The News adapter to show the news in a list.
 */
class NewsArticlesAdapter(
        private var newsArticleDb: List<NewsArticleDb>,
        private var itemClick: ItemClick,
        private var context:Context
) : RecyclerView.Adapter<NewsArticlesAdapter.RecyclerViewHolders>() {

    override fun getItemCount(): Int {
        return if (newsArticleDb == null) {
            0
        } else {
            newsArticleDb!!.size
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onBindViewHolder(holder: RecyclerViewHolders, position: Int) {
        val watchlistData = newsArticleDb[position]
        holder.binding.newsList = watchlistData
        holder.binding.newsImage.load(watchlistData.urlToImage) {
            placeholder(R.drawable.tools_placeholder)
            error(R.drawable.tools_placeholder)
        }
        holder.binding.cardView.setOnClickListener {
            itemClick.click(watchlistData)
        }
    }

    class RecyclerViewHolders(val binding: RowNewsArticleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolders {
        val binding = RowNewsArticleBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return RecyclerViewHolders(binding)
    }
}

