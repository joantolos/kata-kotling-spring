package com.joantolos.kata.kotlin.spring.api

import com.joantolos.kata.kotlin.spring.domain.dao.User
import com.joantolos.kata.kotlin.spring.domain.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserResource(val userService: UserService) {

    @RequestMapping(value = ["/users"], method = [RequestMethod.GET])
    @ResponseStatus(HttpStatus.OK)
    fun getUsers(): List<User> = userService.getUsers()

    @RequestMapping(value = ["/users"], method = [RequestMethod.POST])
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@RequestBody user: User) = userService.addUser(user)

    @RequestMapping(value = ["/users"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteUser(@RequestBody user: User) = userService.deleteUser(user)

    @RequestMapping(value = ["/users"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.CREATED)
    fun updateUser(@RequestBody user: User) = userService.updateUser(user)
}