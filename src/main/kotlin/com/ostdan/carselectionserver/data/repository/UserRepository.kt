package com.ostdan.carselectionserver.data.repository

import com.ostdan.carselectionserver.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
}