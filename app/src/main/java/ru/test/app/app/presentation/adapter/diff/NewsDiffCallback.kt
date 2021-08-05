package ru.test.app.app.presentation.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import ru.test.app.app.presentation.model.NewsItem

class NewsDiffCallback : DiffUtil.ItemCallback<NewsItem>() {

    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.title == newItem.title && oldItem.description == newItem.description
    }
}
