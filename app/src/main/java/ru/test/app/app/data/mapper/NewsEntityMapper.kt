package ru.test.app.app.data.mapper

import ru.test.app.app.data.database.NewsEntity
import ru.test.app.app.data.model.NewsResponse
import javax.inject.Inject

class NewsEntityMapper @Inject constructor() {

    fun map(data: NewsResponse): List<NewsEntity> {
        return data.documents?.values?.mapNotNull(::mapDocument).orEmpty()
    }

    private fun mapDocument(data: NewsResponse.Document): NewsEntity? {
        val posterUrl = data.image?.values?.firstOrNull()

        return NewsEntity(
            url = data.url ?: return null,
            title = data.title ?: return null,
            secondTitle = data.secondTitle,
            posterUrl = posterUrl
        )
    }
}
