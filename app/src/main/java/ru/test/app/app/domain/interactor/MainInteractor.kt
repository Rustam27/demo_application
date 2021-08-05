package ru.test.app.app.domain.interactor

import ru.test.app.app.data.repository.MainRepository
import ru.test.app.base.Status
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val mainRepository: MainRepository,
) {

    suspend fun loadNewsFormApi(): Status {
        val throwable = mainRepository.loadNewsFromApi()

        return throwable
            ?.let { Status.Error(throwable) }
            ?: Status.Success
    }

    fun getNews() = mainRepository.getNews()
}
