package com.ostdan.carselectionserver.data.mapper

import com.ostdan.carselectionserver.data.model.CheckGroupResponse
import com.ostdan.carselectionserver.domain.model.CheckGroup

class CheckGroupMapper {
    companion object {
        fun toCheckGroupResponse(from: CheckGroup): CheckGroupResponse {
            val checkCategoryList: List<CheckGroupResponse.Category> = from.checkList
                .groupBy { it.category }
                .mapValues { (_, checks) ->
                    checks.map { CheckGroupResponse.Category.Check(it.checkId, it.title, it.status?.text, it.image) }
                }
                .map { (category, checks) ->
                    CheckGroupResponse.Category(category, checks)
                }
            return CheckGroupResponse(
                from.checkGroupId,
                from.name,
                from.completion,
                from.image,
                checkCategoryList)
        }
    }
}