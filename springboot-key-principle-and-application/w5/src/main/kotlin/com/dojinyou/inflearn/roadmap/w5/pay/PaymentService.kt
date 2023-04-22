package com.dojinyou.inflearn.roadmap.w5.pay

import org.springframework.stereotype.Component

@Component
class PaymentService(
    private val paymentClient: PaymentClient,
) {

    fun pay(amount: Int) {
        paymentClient.pay(amount)
    }
}
