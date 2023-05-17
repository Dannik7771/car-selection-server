package com.ostdan.carselectionserver.domain.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonFormat

enum class OverallCheckStatus(
    val text: String
) {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Unknown("Не определено"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Verified("Проверено"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Junk("Автомобиль не годен к покупке"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Hijacking("Автомобиль в угоне"),
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Fraud("Выявлено потенциальное мошенничество");

    companion object {
        @JsonCreator
        fun fromText(name: String): OverallCheckStatus? {
            return values().find { it.name == name }
        }
    }
}