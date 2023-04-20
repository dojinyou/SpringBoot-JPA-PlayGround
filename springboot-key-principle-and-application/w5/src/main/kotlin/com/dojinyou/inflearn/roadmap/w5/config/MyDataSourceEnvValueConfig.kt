package com.dojinyou.inflearn.roadmap.w5.config

import com.dojinyou.inflearn.roadmap.w5.datasource.MyDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class MyDataSourceEnvValueConfig(
    @Value("\${my.datasource.url}")
    private val url: String,
    @Value("\${my.datasource.username}")
    private val username: String,
    @Value("\${my.datasource.password}")
    private val password: String,
    @Value("\${my.datasource.max-connection:2}")
    private val maxConnection: Int,
    @Value("\${my.datasource.timeout}")
    private val timeout: Duration,
    @Value("\${my.datasource.options}")
    private val options: List<String>,
) {
    @Bean
    fun myDataSource1(): MyDataSource = MyDataSource(url, username, password, maxConnection, timeout, options)

    @Bean
    fun myDataSource2(
        @Value("\${my.datasource.url}") url: String,
        @Value("\${my.datasource.username}") username: String,
        @Value("\${my.datasource.password}") password: String,
        @Value("\${my.datasource.max-connection:2}") maxConnection: Int,
        @Value("\${my.datasource.timeout}") timeout: Duration,
        @Value("\${my.datasource.options}") options: List<String>,
    ): MyDataSource = MyDataSource(url, username, password, maxConnection, timeout, options)
}
