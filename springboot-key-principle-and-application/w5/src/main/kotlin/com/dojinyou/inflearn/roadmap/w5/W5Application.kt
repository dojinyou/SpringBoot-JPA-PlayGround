package com.dojinyou.inflearn.roadmap.w5

import com.dojinyou.inflearn.roadmap.w5.config.MyDataSourceEnvValueConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(MyDataSourceEnvValueConfig::class)
@SpringBootApplication(scanBasePackages = ["com.dojinyou.inflearn.roadmap.w5.datasource"])
class W5Application

fun main(args: Array<String>) {
    runApplication<W5Application>(*args)
}
