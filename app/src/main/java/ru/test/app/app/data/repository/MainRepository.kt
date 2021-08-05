package ru.test.app.app.data.repository

import ru.test.app.app.data.database.NewsDao
import ru.test.app.app.data.mapper.NewsEntityMapper
import ru.test.app.data.MeduzaApi
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val meduzaApi: MeduzaApi,
    private val newsDao: NewsDao,
    private val newsEntityMapper: NewsEntityMapper,
) {

    suspend fun loadNewsFromApi(): Throwable? {
        return runCatching {
            val response = meduzaApi.getNews()

            newsDao.insertAll(newsEntityMapper.map(response))

            null
        }.getOrElse { throwable -> throwable }
    }

    fun getNews() = newsDao.getNews()
}
