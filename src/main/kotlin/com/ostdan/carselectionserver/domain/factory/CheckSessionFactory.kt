package com.ostdan.carselectionserver.domain.factory

import com.fasterxml.jackson.databind.JsonNode
import com.ostdan.carselectionserver.domain.model.CheckSession
import com.ostdan.carselectionserver.domain.model.LegalCheck

class CheckSessionFactory {
    companion object {
        fun create(legalCheck: LegalCheck,
                   checkResult: JsonNode,
                   checkGroupList: JsonNode): CheckSession {
            //
            return CheckSession(
                vin = legalCheck.history?.bodyNumber.toString(),
                govNumber = "",
                checkResult = CheckResultFactory.create(legalCheck, checkResult),
                legalCheck = legalCheck,
                checkGroupList = checkGroupList.map {
                    CheckGroupFactory.create(legalCheck, it)
                }.toMutableList()
            )
        }
    }
}