package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.Step
import org.springframework.data.jpa.repository.JpaRepository

interface StepRepository : JpaRepository<Step, String> {
}