package com.dojinyou.inflearn.roadmap.w5.pay

import org.tinylog.kotlin.Logger

class TestPaymentClient : PaymentClient {
    override fun pay(amount: Int) {
        Logger.info("test payment client pay $amount")
    }
}
