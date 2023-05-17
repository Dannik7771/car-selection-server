package com.ostdan.carselectionserver.domain.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import jakarta.persistence.*
import kotlinx.serialization.Serializable
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Serializable
@Entity
data class VehiclePassport(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val vehiclePassportId: String,
    @SerializedName("number") val number: String?,
    @SerializedName("issue") val issue: String?
)

@Serializable
@Entity
data class OwnershipPeriod(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val ownershipPeriodId: String,
    @SerializedName("person") val person: Int?,
    @SerializedName("personType") val personType: String?,
    @SerializedName("from") val from_owner: String?,
    @SerializedName("to") val to_owner: String?,
    @SerializedName("lastOperationId") val lastOperationId: String?,
    @SerializedName("lastOperation") val lastOperation: String?,
    @SerializedName("periodDescription") val periodDescription: String?
)

@Serializable
@Entity
data class History(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val historyId: String,
    @SerializedName("bodyNumber") val bodyNumber: String?,
    @SerializedName("chassisNumber") val chassisNumber: String?,
    @SerializedName("engineNumber") val engineNumber: String?,
    @SerializedName("engineVolume") val engineVolume: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("powerHp") val powerHp: String?,
    @SerializedName("powerKwt") val powerKwt: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("vin") val vin: String?,
    @SerializedName("year") val year: String?,
    @OneToOne(cascade=[CascadeType.ALL])
    @SerializedName("vehiclePassport") val vehiclePassport: VehiclePassport,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    @SerializedName("ownershipPeriods") val ownershipPeriods: List<OwnershipPeriod>
)

@Serializable
@Entity
data class Accident(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val accidentId: String,
    @SerializedName("vehicleYear") val vehicleYear: String?,
    @SerializedName("accidentDatetime") val accidentDatetime: String?,
    @SerializedName("accidentNumber") val accidentNumber: String?,
    @SerializedName("accidentType") val accidentType: String?,
    @SerializedName("regionName") val regionName: String?,
    @SerializedName("mark") val mark: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("damagePoints") val damagePoints: List<String>,
    @SerializedName("vehicleDamageState") val vehicleDamageState: String?,
    @SerializedName("damageImages") val damageImages: String?,
    @SerializedName("accidentPlace") val accidentPlace: String?,
    @SerializedName("damageDescription") val damageDescription: String?,
    @SerializedName("ownerOkopf") val ownerOkopf: String?,
    @SerializedName("vehicleAmount") val vehicleAmount: String?,
    @SerializedName("vehicleSort") val vehicleSort: String?
)

@Serializable
@Entity
data class Search(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val searchId: String,
    @SerializedName("search_date") val searchDate: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("model_year") val modelYear: String?,
    @SerializedName("region") val region: String?
)

@Serializable
@Entity
data class Restriction(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val restrictionId: String,
    @SerializedName("model") val model: String?,
    @SerializedName("model_year") val modelYear: String?,
    @SerializedName("vin") val vin: String?,
    @SerializedName("carBodyNumber") val carBodyNumber: String?,
    @SerializedName("restriction_date") val restrictionDate: String?,
    @SerializedName("region") val region: String?,
    @SerializedName("organization_name") val organizationName: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("restriction_name") val restrictionName: String?,
    @SerializedName("reasons") val reasons: String?,
    @SerializedName("organization_code") val organizationCode: Int?,
    @SerializedName("restriction_code") val restrictionCode: Int?,
    @SerializedName("codDL") val codDL: Int?,
    @SerializedName("codeTo") val codeTo: Int?,
    @SerializedName("divisionId") val divisionId: String?,
    @SerializedName("gid") val gid: String?,
    @SerializedName("regId") val regId: String?
)

@Serializable
@Entity
data class PreviousDiagnosticCard(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val previousDiagnosticCardId: String,
    @SerializedName("dcDate") val dcDate: String?,
    @SerializedName("dcExpirationDate") val dcExpirationDate: String?,
    @SerializedName("dcNumber") val dcNumber: String?,
    @SerializedName("odometerValue") val odometerValue: String?
)

@Serializable
@Entity
data class DiagnosticCard(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val diagnosticCardId: String,
    @SerializedName("vin") val vin: String?,
    @SerializedName("body") val body: String?,
    @SerializedName("brand") val brand: String?,
    @SerializedName("chassis") val chassis: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("odometerValue") val odometerValue: String?,
    @SerializedName("operatorName") val operatorName: String?,
    @SerializedName("pdfBase64") val pdfBase64: String?,
    @SerializedName("pointAddress") val pointAddress: String?,
    @SerializedName("success") val success: Boolean?,
    @SerializedName("dcDate") val dcDate: String?,
    @SerializedName("dcExpirationDate") val dcExpirationDate: String?,
    @SerializedName("dcNumber") val dcNumber: String?,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    @SerializedName("previousDc") val previousDc: List<PreviousDiagnosticCard>
) {
    class Deserializer : ResponseDeserializable<DiagnosticCard> {
        override fun deserialize(content: String): DiagnosticCard = Gson().fromJson(content, DiagnosticCard::class.java)
    }
}

@Serializable
@Entity
data class Status(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val statusId: String,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?
)

@Serializable
@Entity
data class LegalCheck(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val legalCheckResponseId: String,
    @SerializedName("gibdd_done") val gibddDone: Int,
    @SerializedName("gibdd_history_done") val gibddHistoryDone: Int,
    @SerializedName("gibdd_accidents_done") val gibddAccidentsDone: Int,
    @SerializedName("gibdd_searches_done") val gibddSearchesDone: Int,
    @SerializedName("gibdd_restrictions_done") val gibddRestrictionsDone: Int,
    @SerializedName("gibdd_diagnostic_card_done") val gibddDiagnosticCardDone: Int,

    @OneToOne(cascade=[CascadeType.ALL])
    @SerializedName("history") val history: History?,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    @SerializedName("accidents") val accidents: List<Accident>,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    @SerializedName("searches") val searches: List<Search>,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    @SerializedName("restrictions") val restrictions: List<Restriction>,

    @OneToMany(cascade=[CascadeType.ALL])
    @JoinColumn
    @OnDelete(action= OnDeleteAction.CASCADE)
    @SerializedName("diagnosticCards") val diagnosticCards: List<DiagnosticCard>,

    @OneToOne(cascade=[CascadeType.ALL])
    @SerializedName("status") val status: Status
)
{
    class Deserializer : ResponseDeserializable<LegalCheck> {
        override fun deserialize(content: String): LegalCheck = Gson().fromJson(content, LegalCheck::class.java)
    }
}

