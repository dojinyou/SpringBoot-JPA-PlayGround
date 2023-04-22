package com.dojinyou.inflearn.roadmap.w5.datasource

import org.springframework.boot.context.properties.ConfigurationProperties
import java.time.Duration

@ConfigurationProperties(prefix = "my.datasource2")
data class MyDataSourcePropertiesV1(
    val url: String,
    val username: String,
    val password: String,
    val etc: Etc,
) {
    data class Etc(
        val maxConnection: Int,
        val timeout: Duration,
        val options: List<String>,
    )
}
