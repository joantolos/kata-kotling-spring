package com.joantolos.kata.kotlin.spring.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @RequestMapping(value = ["/users"], method = [RequestMethod.GET])
    fun users(): List<User> {
        return listOf(
                User("luke", "123"),
                User("vader", "456"),
                User("yoda", "789"),
        )
    }
}

data class User(val username: String, val password: String)