package ru.test.app.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        NewsEntity::class,
    ]
)
abstract class NewsDatabase : RoomDatabase() {
    abstract val newsDao: NewsDao

    companion object {
        const val DATABASE_NAME = "db.news"
    }
}

