package com.ostdan.carselectionserver.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*

@Entity
@Table
data class CheckGroup (
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val checkGroupId: String = UUID.randomUUID().toString(),
    val name: String,
    val completion: Float,
    val image: String,
    val type: String,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    val checkList: MutableList<Check> = mutableListOf(),
)