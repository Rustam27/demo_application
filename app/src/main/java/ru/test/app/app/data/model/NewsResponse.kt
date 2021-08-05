package ru.test.app.app.data.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(

    @SerializedName("has_next")
    val hasNext: Boolean?,

    @SerializedName("documents")
    val documents: Map<String, Document>?,
) {

    data class Document(

        @SerializedName("url")
        val url: String?,

        @SerializedName("title")
        val title: String?,

        @SerializedName("second_title")
        val secondTitle: String?,

        @SerializedName("image")
        val image: Map<String, String>?,
    )
}
