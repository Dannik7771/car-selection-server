package com.ostdan.carselectionserver.domain.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonFormat

enum class StepType {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Default,
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    VINCheck;

    companion object {
        @JsonCreator
        fun fromText(name: String): StepType? {
            return values().find { it.name == name }
        }
    }
}