package com.ostdan.carselectionserver.domain.factory

import com.fasterxml.jackson.databind.JsonNode
import com.ostdan.carselectionserver.domain.model.LegalCheck
import com.ostdan.carselectionserver.domain.model.Step
import com.ostdan.carselectionserver.domain.model.StepType

class StepFactory {
    companion object {
        fun create(legalCheck: LegalCheck, step: JsonNode): Step {
            //
            return Step(
                title = step["title"].asText(),
                description = step["description"].asText(),
                descriptionWarning = step["descriptionWarning"].asText(),
                type = StepType.fromText(step["type"].asText()),
                stepImageList = step["stepImageList"].asText(),
                question = Step.Question(
                    text = step["question"]["text"].asText(),
                    answers = step["question"]["answers"].map {
                        Step.Question.Answer(
                            text = it["text"].asText(),
                            textWhenSelected = it["textWhenSelected"].asText()
                        )
                    }.toMutableList()
                )
            )
        }
    }
}