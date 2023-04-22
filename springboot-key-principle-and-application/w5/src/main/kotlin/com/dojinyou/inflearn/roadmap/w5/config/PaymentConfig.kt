package com.dojinyou.inflearn.roadmap.w5.config

import com.dojinyou.inflearn.roadmap.w5.pay.ProdPaymentClient
import com.dojinyou.inflearn.roadmap.w5.pay.TestPaymentClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.tinylog.kotlin.Logger

@Configuration
class PaymentConfig {

    @Bean
    @Profile("default")
    fun testPaymentClient(): TestPaymentClient {
        Logger.info("create testPaymentClient")
        return TestPaymentClient()
    }

    @Bean
    @Profile("prod")
    fun prodPaymentClient(): ProdPaymentClient {
        Logger.info("create prodPaymentClient")
        return ProdPaymentClient()
    }
}
