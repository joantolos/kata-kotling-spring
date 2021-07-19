package com.joantolos.kata.kotlin.spring.domain.service

import com.joantolos.kata.kotlin.spring.domain.dao.Message
import com.joantolos.kata.kotlin.spring.domain.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message){
        db.save(message)
    }
}