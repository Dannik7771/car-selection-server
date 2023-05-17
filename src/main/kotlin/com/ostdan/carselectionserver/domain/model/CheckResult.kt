package com.ostdan.carselectionserver.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table
data class CheckResult(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val checkResultId: String = UUID.randomUUID().toString(),
    val brand: String,
    val model: String,
    val overallStatus: OverallCheckStatus?,
    val completion: Float,
    val text: String,
    val image: String
)