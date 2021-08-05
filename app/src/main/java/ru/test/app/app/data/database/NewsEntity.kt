package ru.test.app.app.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NewsEntity.TABLE_NAME)
data class NewsEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = COLUMN_URL)
    val url: String,

    @ColumnInfo(name = COLUMN_TITLE)
    val title: String,

    @ColumnInfo(name = COLUMN_SECOND_TITLE)
    val secondTitle: String?,

    @ColumnInfo(name = COLUMN_POSTER)
    val posterUrl: String?,
) {

    companion object {
        const val TABLE_NAME = "tb_news"

        const val COLUMN_URL = "url"
        const val COLUMN_TITLE = "title"
        const val COLUMN_SECOND_TITLE = "secondTitle"
        const val COLUMN_POSTER = "poster"
    }
}
