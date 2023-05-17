package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.CheckSession
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckSessionRepository : JpaRepository <CheckSession, String> {
}