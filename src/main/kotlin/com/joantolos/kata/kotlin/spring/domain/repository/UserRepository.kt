package com.joantolos.kata.kotlin.spring.domain.repository

import com.joantolos.kata.kotlin.spring.domain.dao.User
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface UserRepository : CrudRepository<User, String> {

    @Query("select * from users")
    fun findMessages(): List<User>

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (username, password) VALUES(:username, :password);")
    fun addUser(username: String?, password: String?)
}