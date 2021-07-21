package com.joantolos.kata.kotlin.spring.domain.service

import com.joantolos.kata.kotlin.spring.domain.dao.User
import com.joantolos.kata.kotlin.spring.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun getUsers(): List<User> = userRepository.findUsers()

    fun addUser(user: User) = userRepository.addUser(user.username, user.password)

    fun deleteUser(user: User) = userRepository.deleteUser(user.username)

    fun updateUser(user: User) = userRepository.updateUser(user.username, user.password)
}