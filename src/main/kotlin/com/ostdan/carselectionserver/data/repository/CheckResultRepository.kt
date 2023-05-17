package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.CheckResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckResultRepository : JpaRepository <CheckResult, String>{
}