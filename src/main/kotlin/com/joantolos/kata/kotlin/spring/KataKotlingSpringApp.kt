package com.joantolos.kata.kotlin.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KataKotlinSpringApplication

fun main(args: Array<String>) {
	runApplication<KataKotlinSpringApplication>(*args)
}