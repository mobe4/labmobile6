package com.example.lab6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lab6.databinding.NewsViewBinding
import com.example.lab6.databinding.SportViewBinding
import com.example.lab6.fragments.NewsFragment
import com.example.lab6.fragments.SportsFragment

class NewsRecyclerViewAdapter(private val news : MutableList<NewsFragment.Companion.NewsArticle>) : RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>() {

    class  NewsViewHolder(private val binding: NewsViewBinding) : ViewHolder(binding.root){
        fun populate(news : NewsFragment.Companion.NewsArticle){
            binding.newsTitleTextView.text = news.title
            binding.newsDescriptionTextView.text = news.description

            Glide
                .with(binding.root)
                .load(news.urlToImage)
                .centerCrop()
                .into(binding.newsImageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder( NewsViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {

        return news.size

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.populate(news[position])
    }
}