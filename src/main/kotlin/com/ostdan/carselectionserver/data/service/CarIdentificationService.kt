package com.ostdan.carselectionserver.data.service

import com.github.kittinunf.fuel.httpGet
import com.ostdan.carselectionserver.data.mapper.CheckSessionMapper
import com.ostdan.carselectionserver.data.model.CheckSessionResponse
import com.ostdan.carselectionserver.data.repository.UserRepository
import com.ostdan.carselectionserver.domain.model.CheckSession
import com.ostdan.carselectionserver.domain.model.LegalCheck
import com.ostdan.carselectionserver.domain.model.Role
import com.ostdan.carselectionserver.domain.model.User
import org.hibernate.Hibernate
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarIdentificationService(
    val userRepository: UserRepository,
    val checkSessionService: CheckSessionService
) {

    val url: String = "http://localhost:8088/parserapi/v1/gibdd/auto"

    fun getCarByVIN(searchQuery: String, userId: String): CheckSessionResponse  {
        return searchAndSaveOrUpdateCheckSession(userId, vin = searchQuery)
    }

    /*fun getCarByGovNumber(searchQuery: String, userId: String): CheckSessionResponse {
        return searchAndSaveOrUpdateCheckSession(userId, vin=null, govNumber=searchQuery)
    }*/

    fun searchAndSaveOrUpdateCheckSession(userId: String, vin: String): CheckSessionResponse {
        val user: User = userRepository.findById(userId).get()
        Hibernate.initialize(user.sessions)

        var session: CheckSession? = user.sessions.find { it.vin == vin }
        var shouldSaveSession = false

        if (session == null) {
            println(user)
            val result = url.httpGet().responseObject(LegalCheck.Deserializer()).third
                val legalCheckAPIResponse = result.component1()
                legalCheckAPIResponse?.let {
                    val generatedSession = checkSessionService.generateSession(it)
                    session = generatedSession
                    user.sessions.add(generatedSession)
                    shouldSaveSession = true
                }
        }

        if (shouldSaveSession) {
            userRepository.save(user)
        }

        return session?.let { CheckSessionMapper.toCheckSessionResponse(it) }
            ?: throw IllegalStateException("Failed to retrieve or generate check session.")
    }
}