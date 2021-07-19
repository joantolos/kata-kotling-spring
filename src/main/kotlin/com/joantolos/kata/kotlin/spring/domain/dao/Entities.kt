package com.joantolos.kata.kotlin.spring.domain.dao

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("USERS")
data class User(@Id val username: String, val password: String)