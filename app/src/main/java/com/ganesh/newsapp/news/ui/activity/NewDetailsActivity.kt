package com.ganesh.newsapp.news.ui.activity

import android.os.Bundle
import android.view.View
import coil.api.load
import com.ganesh.newsapp.R
import com.ganesh.newsapp.core.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_new_details.*
import kotlinx.android.synthetic.main.card_layout.*


class NewDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_details)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTextAppernce()
        val authors= intent.getStringExtra("author")
        val titles= intent.getStringExtra("title")
        val urlToImage=intent.getStringExtra("urlToImage")
        val publishedAt= intent.getStringExtra("publishedAt")
        titless.text=titles.toString()
        collapsing_toolbar.setTitle(authors)
        author.text=authors.toString()
        published.text=publishedAt.toString()
        profile_id.load(urlToImage) {
            placeholder(R.drawable.tools_placeholder)
            error(R.drawable.tools_placeholder)
        }

        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                finish()
            }
        })
    }
    private fun toolbarTextAppernce() {
        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.collapsedappbar)
        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.expandedappbar)
    }

}