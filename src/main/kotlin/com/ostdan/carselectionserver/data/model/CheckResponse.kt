package com.ostdan.carselectionserver.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CheckResponse(
    @SerialName("checkId") val checkId: String,
    @SerialName("title") val title: String,
    @SerialName("status") val status: String?,
    @SerialName("description") val description: String,
    @SerialName("descriptionWarning") val descriptionWarning: String,
    @SerialName("descriptionAlert") val descriptionAlert: String,
    @SerialName("category") val category: String,
    @SerialName("image") val image: String,
    @SerialName("steps") val steps: List<Step>
) {
    @Serializable
    data class Step(
        @SerialName("stepId") val stepId: String,
        @SerialName("title") val title: String,
        @SerialName("description") val description: String,
        @SerialName("descriptionWarning") val descriptionWarning: String,
        @SerialName("stepImage") val stepImage: String,
        @SerialName("question") val question: Question,
    ) {
        @Serializable
        data class Question(
            @SerialName("questionId") val questionId: String,
            @SerialName("text") val text: String,
            @SerialName("answers") val answers: List<Answer>,
            @SerialName("selectedAnswerId") val selectedAnswerId: String? = null
        ) {
            @Serializable
            data class Answer (
                @SerialName("answerId") val answerId: String,
                @SerialName("text") val text: String,
            )
        }
    }
}