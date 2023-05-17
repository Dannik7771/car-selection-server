package com.ostdan.carselectionserver.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*


@Entity
@Table
data class CheckSession(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val checkSessionId: String = UUID.randomUUID().toString(),
    val vin: String,
    val govNumber: String,

    @OneToOne(cascade=[CascadeType.ALL])
    val checkResult: CheckResult,

    @OneToOne(cascade=[CascadeType.ALL])
    val legalCheck: LegalCheck,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    val checkGroupList: MutableList<CheckGroup> = mutableListOf(),
)