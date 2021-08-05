package ru.test.app.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.test.app.app.data.model.NewsResponse

interface MeduzaApi {

    @GET("api/v3/search")
    suspend fun getNews(
        @Query("chrono") chrono: String = "news",
        @Query("locale") locale: String = "ru",
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 24,
    ): NewsResponse
}
