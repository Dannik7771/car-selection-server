package com.ostdan.carselectionserver.data.service

import com.ostdan.carselectionserver.data.repository.UserRepository
import com.ostdan.carselectionserver.domain.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: UserRepository
) {
    fun postUser(user: User): User {
        return repository.save(user)
    }

    fun getUser(id: String): User {
        return repository.findById(id).get()
    }

    fun putUser(user: User): User {
        return repository.save(user)
    }

    fun delete(id: String) {
        return repository.deleteById(id)
    }

}