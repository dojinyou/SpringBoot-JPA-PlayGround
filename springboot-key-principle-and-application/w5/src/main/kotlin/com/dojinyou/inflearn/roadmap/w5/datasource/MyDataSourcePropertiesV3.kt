package com.dojinyou.inflearn.roadmap.w5.datasource

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.time.DurationMax
import org.hibernate.validator.constraints.time.DurationMin
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import java.time.Duration
import java.time.temporal.TemporalUnit

@ConfigurationProperties(prefix = "my.datasource.v3")
@Validated
data class MyDataSourcePropertiesV3(
    @field:NotEmpty
    val url: String,

    @field:NotEmpty
    val username: String,

    @field:NotEmpty
    val password: String,

    val etc: Etc,
) {
    data class Etc(
        @field:Min(1)
        @field:Max(999)
        val maxConnection: Int,

        @field:DurationMin(seconds = 1)
        @field:DurationMax(seconds = 60)
        val timeout: Duration,

        val options: List<String>,
    )
}
