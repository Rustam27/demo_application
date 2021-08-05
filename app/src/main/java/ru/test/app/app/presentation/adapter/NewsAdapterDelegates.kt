package ru.test.app.app.presentation.adapter

import androidx.core.view.isVisible
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.test.app.app.presentation.model.NewsItem
import ru.test.app.databinding.ItemNewsBinding
import ru.test.app.utils.extensions.load
import ru.test.app.utils.extensions.setTextOrGoneIfEmpty

fun newsDelegate() = adapterDelegateViewBinding<NewsItem, NewsItem, ItemNewsBinding>(
    { layoutInflater, root -> ItemNewsBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        with(binding) {
            mainTitleTextView.text = item.title
            mainDescriptionTextView.setTextOrGoneIfEmpty(item.description)
            mainPosterTextView.load(item.posterUrl)
            mainPosterTextView.isVisible = item.posterUrl != null
        }
    }
}

