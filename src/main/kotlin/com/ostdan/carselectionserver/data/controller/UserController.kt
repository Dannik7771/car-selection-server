package com.ostdan.carselectionserver.data.controller

import com.ostdan.carselectionserver.data.service.UserService
import com.ostdan.carselectionserver.domain.model.User
import com.ostdan.carselectionserver.log.Logging
import com.ostdan.carselectionserver.log.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(
    val service: UserService
) : Logging {
    @PostMapping
    fun postUser(@RequestBody user: User): User {
        logger().info("\"postUser\" with user=\'{}\'", user)
        return service.postUser(user)
    }

    @GetMapping
    fun getUser(@RequestParam("id") id: String): ResponseEntity<User> {
        logger().info("\"getUser\" with id=\'{}\'", id)
        return ResponseEntity.ok(service.getUser(id))
    }

    @PutMapping
    fun putUser(@RequestBody user: User): User {
        logger().info("\"putUser\" with user=\'{}\'", user)
        return service.putUser(user)
    }

    @DeleteMapping
    fun deleteUser(@RequestParam("id") id: String) {
        logger().info("\"deleteUser\" with id=\'{}\'", id)
        return service.delete(id)
    }
}