package ru.test.app.app.presentation.mapper

import ru.test.app.BuildConfig
import ru.test.app.app.data.database.NewsEntity
import ru.test.app.app.presentation.model.NewsItem
import javax.inject.Inject

class NewItemUiModelMapper @Inject constructor() {

    fun map(data: List<NewsEntity>): List<NewsItem> {
        return data.map(::mapDocument)
    }

    private fun mapDocument(data: NewsEntity): NewsItem {
        val posterUrl = data.posterUrl?.let { url -> BuildConfig.MEDUZA_URL + url }

        return NewsItem(
            url = data.url,
            title = data.title,
            description = data.secondTitle,
            posterUrl = posterUrl
        )
    }
}
