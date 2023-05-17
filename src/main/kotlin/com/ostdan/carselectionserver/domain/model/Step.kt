package com.ostdan.carselectionserver.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*


@Entity
@Table
data class Step(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val stepId: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val descriptionWarning: String,
    val type: StepType?,
    val stepImageList: String, //TODO: List<StepImage>

    @OneToOne(cascade=[CascadeType.ALL])
    val question: Question,
) {
    @Entity
    @Table
    data class Question(
        @Id @GeneratedValue(strategy = GenerationType.UUID)
        val questionId: String = UUID.randomUUID().toString(),
        val text: String,

        @OneToMany(cascade=[CascadeType.ALL])
        @JoinColumn
        @OnDelete(action= OnDeleteAction.CASCADE)
        val answers: MutableList<Answer> = mutableListOf(),
        val selectedAnswerId: String? = null
    ) {
        @Entity
        @Table
        data class Answer (
            @Id @GeneratedValue(strategy = GenerationType.UUID)
            val answerId: String = UUID.randomUUID().toString(),
            val text: String,
            val textWhenSelected: String,
        )
    }
}