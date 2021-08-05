package ru.test.app.app.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.test.app.app.presentation.adapter.diff.NewsDiffCallback
import ru.test.app.app.presentation.model.NewsItem

class NewsAdapter : AsyncListDifferDelegationAdapter<NewsItem>(
    NewsDiffCallback(),
    newsDelegate()
)
