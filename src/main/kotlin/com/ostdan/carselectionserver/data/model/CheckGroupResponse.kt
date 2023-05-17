package com.ostdan.carselectionserver.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CheckGroupResponse(
    @SerialName("checkGroupId") val checkGroupId: String,
    @SerialName("name") val name: String,
    @SerialName("completion") val completion: Float,
    @SerialName("image") val image: String,
    @SerialName("categories") val categories: List<Category>,
) {
    @Serializable
    data class Category(
        @SerialName("category") val category: String,
        @SerialName("checks") val checks: List<Check>
    ) {
        @Serializable
        data class Check(
            @SerialName("checkId") val checkId: String,
            @SerialName("title") val title: String,
            @SerialName("status") val status: String?,
            @SerialName("image") val image: String
        )
    }
}