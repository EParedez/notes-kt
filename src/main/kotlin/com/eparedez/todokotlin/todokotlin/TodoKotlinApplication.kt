package com.eparedez.todokotlin.todokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(TodoKotlinProperties::class)
class TodoKotlinApplication

fun main(args: Array<String>) {
	runApplication<TodoKotlinApplication>(*args)
}
