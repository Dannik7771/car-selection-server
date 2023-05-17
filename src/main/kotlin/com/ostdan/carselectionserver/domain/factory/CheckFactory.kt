package com.ostdan.carselectionserver.domain.factory

import com.fasterxml.jackson.databind.JsonNode
import com.ostdan.carselectionserver.domain.model.Check
import com.ostdan.carselectionserver.domain.model.CheckStatus
import com.ostdan.carselectionserver.domain.model.LegalCheck
import com.ostdan.carselectionserver.domain.model.OverallCheckStatus

class CheckFactory {
    companion object {
        fun create(legalCheck: LegalCheck, check: JsonNode): Check {
            //
            return Check(
                title = check["title"].asText(),
                status = CheckStatus.fromText(check["status"].asText()),
                description = check["description"].asText(),
                description_warning = check["description_warning"].asText(),
                description_alert = check["description_alert"].asText(),
                category = check["category"].asText(),
                image = check["image"].asText(),
                stepList = check["stepList"].map {
                    StepFactory.create(legalCheck, it)
                }.toMutableList()
            )
        }
    }
}