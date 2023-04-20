package com.dojinyou.inflearn.roadmap.w5.datasource

import jakarta.annotation.PostConstruct
import org.tinylog.kotlin.Logger
import java.time.Duration

class MyDataSource(
    private val url: String?,
    private val username: String?,
    private val password: String?,
    private val maxConnection: Int?,
    private val timeout: Duration?,
    private val options: List<String>?,
) {
    @PostConstruct
    fun init() {
        Logger.info("url = $url")
        Logger.info("username = $username")
        Logger.info("password = $password")
        Logger.info("maxConnection = $maxConnection")
        Logger.info("timeout = $timeout")
        Logger.info("options = $options")
    }
}
