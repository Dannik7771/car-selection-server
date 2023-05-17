package com.ostdan.carselectionserver.domain.factory

import com.fasterxml.jackson.databind.JsonNode
import com.ostdan.carselectionserver.domain.model.CheckResult
import com.ostdan.carselectionserver.domain.model.LegalCheck
import com.ostdan.carselectionserver.domain.model.OverallCheckStatus

class CheckResultFactory {
    companion object {
        fun create(legalCheck: LegalCheck, checkResult: JsonNode): CheckResult {
            //
            return CheckResult(
                brand = legalCheck.diagnosticCards[0].brand.toString(),
                model = legalCheck.diagnosticCards[0].model.toString(),
                overallStatus = OverallCheckStatus.fromText(checkResult["completion"].asText()),
                completion = checkResult["completion"].asDouble().toFloat(),
                text = checkResult["text"].asText(),
                image = checkResult["image"].asText()
            )
        }
    }
}