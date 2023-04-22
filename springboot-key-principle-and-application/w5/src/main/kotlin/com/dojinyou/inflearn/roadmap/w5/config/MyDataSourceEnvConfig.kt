package com.dojinyou.inflearn.roadmap.w5.config

import com.dojinyou.inflearn.roadmap.w5.datasource.MyDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import org.tinylog.kotlin.Logger
import java.time.Duration

@Configuration
class MyDataSourceEnvConfig(
    private val environment: Environment,
) {
    @Bean
    fun myDataSource(): MyDataSource {
        Logger.info(this.javaClass.simpleName)
        val url = environment["my.datasource.url"]
        val username = environment["my.datasource.username"]
        val password = environment["my.datasource.password"]
        val maxConnection = environment.getProperty("my.datasource.max-connection", Int::class.java)
        val timeout = environment.getProperty("my.datasource.timeout", Duration::class.java)
        val options = environment["my.datasource.options"]?.split(",")

        return MyDataSource(url, username, password, maxConnection, timeout, options)
    }
}
