package ru.test.app.app.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.test.app.app.data.database.NewsEntity.Companion.TABLE_NAME

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<NewsEntity>)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getNews(): Flow<List<NewsEntity>>
}
