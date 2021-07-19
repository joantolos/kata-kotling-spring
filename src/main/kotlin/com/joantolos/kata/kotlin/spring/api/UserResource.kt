package com.joantolos.kata.kotlin.spring.api

import com.joantolos.kata.kotlin.spring.domain.dao.User
import com.joantolos.kata.kotlin.spring.domain.service.UserService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class UserResource(val service: UserService) {

    @RequestMapping(value = ["/users"], method = [RequestMethod.GET])
    fun getUsers(): List<User> = service.findMessages()

    @RequestMapping(value = ["/users"], method = [RequestMethod.POST])
    private fun addUser(@RequestBody user: User) {
        service.addUser(user)
    }
}