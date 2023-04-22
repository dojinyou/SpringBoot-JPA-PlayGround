package com.dojinyou.inflearn.roadmap.w5

import com.dojinyou.inflearn.roadmap.w5.config.MyDataSourceConfigV3
import com.dojinyou.inflearn.roadmap.w5.config.PaymentConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@Import(MyDataSourceConfigV3::class, PaymentConfig::class)
@SpringBootApplication(scanBasePackages = ["com.dojinyou.inflearn.roadmap.w5.datasource", "com.dojinyou.inflearn.roadmap.w5.pay"])
class W5Application

fun main(args: Array<String>) {
    runApplication<W5Application>(*args)
}
