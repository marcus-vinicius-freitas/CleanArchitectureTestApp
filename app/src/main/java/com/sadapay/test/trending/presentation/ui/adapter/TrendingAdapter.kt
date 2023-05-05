package com.sadapay.test.trending.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sadapay.test.databinding.TrendingRepositoryItemBinding
import com.sadapay.test.trending.domain.models.TrendingItemModel

class TrendingAdapter(private val repositories: List<TrendingItemModel>) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: TrendingRepositoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TrendingRepositoryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = repositories[position]
        holder.binding.repositoryName.text = repository.name
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

}