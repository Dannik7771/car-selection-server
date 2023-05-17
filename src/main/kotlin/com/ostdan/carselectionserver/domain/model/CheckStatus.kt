package com.ostdan.carselectionserver.domain.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonFormat

enum class CheckStatus(
    val text: String,
) {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    NotDone("Не выполнено"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    InProgress("В процессе"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Done("Выполнено"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    ProblemFound("Обнаружена проблема");

    companion object {
        @JsonCreator
        fun fromText(name: String): CheckStatus? {
            return values().find { it.name == name }
        }
    }
}