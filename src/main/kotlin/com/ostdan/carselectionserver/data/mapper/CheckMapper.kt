package com.ostdan.carselectionserver.data.mapper

import com.ostdan.carselectionserver.data.model.CheckResponse
import com.ostdan.carselectionserver.domain.model.Check

class CheckMapper {
    companion object {
        fun toCheckResponse(from: Check): CheckResponse {
            return CheckResponse(
                from.checkId,
                from.title,
                from.status?.text,
                from.description,
            from.description_warning,
            from.description_alert,
            from.category,
            from.image,
            from.stepList.map{ CheckResponse.Step(
                it.stepId,
                it.title,
                it.description,
                it.descriptionWarning,
                it.stepImageList,
            CheckResponse.Step.Question(
                it.question.questionId,
                it.question.text,
                it.question.answers.map { answer -> CheckResponse.Step.Question.Answer(
                    answer.answerId,
                    answer.text
                ) },
                it.question.selectedAnswerId
            )) })
        }
    }
}