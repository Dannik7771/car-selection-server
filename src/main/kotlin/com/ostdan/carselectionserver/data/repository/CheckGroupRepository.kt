package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.CheckGroup
import org.springframework.data.jpa.repository.JpaRepository

interface CheckGroupRepository : JpaRepository <CheckGroup, String> {
}