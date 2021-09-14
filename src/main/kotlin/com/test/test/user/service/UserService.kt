package com.test.test.user.service

import com.test.test.user.model.User
import com.test.test.user.repository.UserRepository
import org.springframework.context.support.AbstractApplicationContext
import org.springframework.stereotype.Service

@Service
class UserService(private val repo: UserRepository,
private val applicationContext: AbstractApplicationContext) {

    fun getAllUsers(): List<User> =
        repo.findAll()

    fun addUser(user: User) = repo.save(user)

    private fun getUser() = repo.getById(1)
}
