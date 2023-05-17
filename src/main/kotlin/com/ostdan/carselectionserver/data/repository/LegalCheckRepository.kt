package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.LegalCheck
import org.springframework.data.jpa.repository.JpaRepository

interface LegalCheckRepository : JpaRepository <LegalCheck, String> {
}