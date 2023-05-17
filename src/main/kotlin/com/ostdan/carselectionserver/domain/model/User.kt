package com.ostdan.carselectionserver.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*

@Entity
@Table (name = "user_table")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val userId: String = UUID.randomUUID().toString(),
    val name: String,
    val password: String,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    val sessions: MutableList<CheckSession> = mutableListOf(),

    val role: Role = Role.User
)