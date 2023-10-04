package com.dojinyou.manytomanty

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ManyToMantyApplication

fun main(args: Array<String>) {
    val nullable = null
    nullable?.let { println("${it ?: "nullable"} is null: ${it == null}")}
    val valueInNullable: String? = "valueInNullable"
    valueInNullable?.let { println("${it ?: "nullable"} is null: ${it == null}")}

//    runApplication<ManyToMantyApplication>(*args)
}
