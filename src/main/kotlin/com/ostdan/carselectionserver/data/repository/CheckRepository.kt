package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.Check
import org.springframework.data.jpa.repository.JpaRepository

interface CheckRepository : JpaRepository <Check, String> {
}