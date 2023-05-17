package com.ostdan.carselectionserver.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*

@Entity
@Table(name = "check_table")
data class Check(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val checkId: String = UUID.randomUUID().toString(),
    val title: String,
    val status: CheckStatus?,
    val description: String,
    val description_warning: String,
    val description_alert: String,
    val category: String,
    val image: String,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    val stepList: MutableList<Step> = mutableListOf(),
)