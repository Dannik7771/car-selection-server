package com.ostdan.carselectionserver.domain.model

data class StepImage (
    val stepImageId: String,
    val image: String,
    val description: String,
    val sign: String,
    val status: String // for moderation
)