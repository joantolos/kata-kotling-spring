package com.joantolos.kata.kotlin.spring.domain.repository

import com.joantolos.kata.kotlin.spring.domain.dao.Message
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String> {

    @Query("select * from messages")
    fun findMessages(): List<Message>
}