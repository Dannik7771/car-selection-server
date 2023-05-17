package com.ostdan.carselectionserver.data.mapper

import com.ostdan.carselectionserver.data.model.CheckSessionResponse
import com.ostdan.carselectionserver.domain.model.CheckSession

class CheckSessionMapper {
    companion object {
        fun toCheckSessionResponse(from: CheckSession): CheckSessionResponse {
            val checkGroupTypeList: List<CheckSessionResponse.Type> = from.checkGroupList
                .groupBy { it.type }
                .mapValues { (_, groups) ->
                    groups.map { CheckSessionResponse.Type.CheckGroup(it.checkGroupId, it.name, it.image) }
                }
                .map { (type, groups) ->
                    CheckSessionResponse.Type(type, groups)
                }
            return CheckSessionResponse(
                from.checkSessionId,
                from.vin,
                from.govNumber,
                checkGroupTypeList)
        }
    }
}