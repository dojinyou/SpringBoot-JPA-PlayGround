package com.dojinyou.inflearn.w4

import jakarta.annotation.PostConstruct
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.springframework.stereotype.Component

@Component
class EnviromentCheck(private val env: Environment) {

    @PostConstruct
    fun init() {
        val url = env["url"]
        val username = env["username"]
        val password = env["password"]
        val common = env["commonconfig"]
        println("url = $url")
        println("username = $username")
        println("password = $password")
        println("common = $common")
    }
}
