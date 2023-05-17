package com.ostdan.carselectionserver.domain.factory

import com.fasterxml.jackson.databind.JsonNode
import com.ostdan.carselectionserver.domain.model.CheckGroup
import com.ostdan.carselectionserver.domain.model.LegalCheck

class CheckGroupFactory {
    companion object {
        fun create(legalCheck: LegalCheck, checkGroup: JsonNode): CheckGroup {
            //
            return CheckGroup(
                name = checkGroup["name"].asText(),
                completion = checkGroup["completion"].asDouble().toFloat(),
                image = checkGroup["image"].asText(),
                type = checkGroup["type"].asText(),
                checkList = checkGroup["checkList"].map {
                    CheckFactory.create(legalCheck, it)
                }.toMutableList()
            )
        }
    }
}