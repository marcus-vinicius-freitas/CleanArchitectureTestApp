package com.marcusfreitas.test.trending.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcusfreitas.test.databinding.TrendingRepositoryItemBinding
import com.marcusfreitas.test.trending.domain.models.TrendingItemModel
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class TrendingAdapter @Inject constructor(@ActivityContext private val context: Context) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: TrendingRepositoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var repositories: List<TrendingItemModel>? = null

    fun setRepositories(repositories: List<TrendingItemModel>) {
        this.repositories = repositories
        notifyItemRangeChanged(0, repositories.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TrendingRepositoryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repository = repositories?.get(position)
        holder.binding.repositoryName.text = repository?.name
        Glide.with(context)
            .load(repository?.owner?.avatarUrl)
            .circleCrop()
            .into(holder.binding.userAvatar)
        holder.binding.userName.text = repository?.owner?.login
        holder.binding.repositoryDescription.text = repository?.description
        holder.binding.languageDot.visibility = if (repository?.language?.isNotEmpty() == true) View.VISIBLE else View.GONE
        holder.binding.language.text = repository?.language
        holder.binding.star.visibility = if (repository?.stargazersCount != null) View.VISIBLE else View.GONE
        holder.binding.startCount.text = repository?.stargazersCount?.toString()
    }

    override fun getItemCount(): Int {
        return repositories?.size ?: 0
    }

}