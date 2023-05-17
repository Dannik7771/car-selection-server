package com.ostdan.carselectionserver.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CheckSessionResponse(
    @SerialName("checkSessionId") val checkSessionId: String,
    @SerialName("vin") val vin: String,
    @SerialName("govNumber") val govNumber: String,
    @SerialName("types") val types: List<Type>
) {
    @Serializable
    data class Type(
        @SerialName("type") val type: String,
        @SerialName("groups") val checkGroups: List<CheckGroup>
    ) {
        @Serializable
        data class CheckGroup(
            @SerialName("checkGroupId") val checkGroupId: String,
            @SerialName("name") val name: String,
            @SerialName("image") val image: String
        )
    }
}