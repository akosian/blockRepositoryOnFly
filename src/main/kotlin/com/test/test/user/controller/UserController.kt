package com.test.test.user.controller

import com.test.test.user.model.User
import com.test.test.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun getAllUsers() = service.getAllUsers()

    @PostMapping
    fun addUser(user: User) = service.addUser(user)
}
