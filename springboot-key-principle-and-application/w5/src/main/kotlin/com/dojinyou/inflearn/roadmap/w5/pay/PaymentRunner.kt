package com.dojinyou.inflearn.roadmap.w5.pay

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class PaymentRunner(
    private val paymentService: PaymentService,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        paymentService.pay(1000)
    }
}
