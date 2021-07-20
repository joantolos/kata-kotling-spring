package com.joantolos.kata.kotlin.spring.domain.repository

import com.joantolos.kata.kotlin.spring.domain.dao.User
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface UserRepository : CrudRepository<User, String> {

    @Query("select * from users")
    fun findUsers(): List<User>

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (username, password) VALUES(:username, :password);")
    fun addUser(username: String?, password: String?)

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE username = :username")
    fun deleteUser(username: String?)

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = :password WHERE username = :username")
    fun updateUser(username: String?, password: String?)
}