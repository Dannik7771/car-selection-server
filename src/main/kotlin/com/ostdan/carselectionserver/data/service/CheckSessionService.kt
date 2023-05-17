package com.ostdan.carselectionserver.data.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.ostdan.carselectionserver.domain.model.LegalCheck
import com.ostdan.carselectionserver.data.repository.*
import com.ostdan.carselectionserver.domain.factory.CheckSessionFactory
import com.ostdan.carselectionserver.domain.model.*
import org.springframework.stereotype.Service
import java.io.File

@Service
class CheckSessionService (
    val checkSessionRepository: CheckSessionRepository) {

    fun generateSession(legalCheck: LegalCheck) : CheckSession {
        val mapper = jacksonObjectMapper()
        val jsonFile = object {}.javaClass.classLoader.getResource("static/rules.json")?.readText()
        return checkSessionRepository.save(
            CheckSessionFactory.create(
                legalCheck,
                mapper.readTree(jsonFile)["checkResult"],
                mapper.readTree(jsonFile)["checkGroupList"]
            )
        )
    }
}