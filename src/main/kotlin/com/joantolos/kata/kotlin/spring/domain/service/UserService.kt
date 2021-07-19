package com.joantolos.kata.kotlin.spring.domain.service

import com.joantolos.kata.kotlin.spring.domain.dao.User
import com.joantolos.kata.kotlin.spring.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val db: UserRepository) {

    fun findMessages(): List<User> = db.findMessages()

    fun addUser(user: User){
        db.addUser(user.username, user.password)
    }
}