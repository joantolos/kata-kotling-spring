package com.joantolos.kata.kotlin.spring.api

import com.joantolos.kata.kotlin.spring.domain.dao.Message
import com.joantolos.kata.kotlin.spring.domain.service.MessageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageResource(val service: MessageService) {

    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @PostMapping
    private fun post(@RequestBody message: Message) {
        service.post(message)
    }
}