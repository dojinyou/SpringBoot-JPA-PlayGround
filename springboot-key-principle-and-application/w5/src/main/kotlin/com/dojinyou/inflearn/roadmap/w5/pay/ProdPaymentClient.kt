package com.dojinyou.inflearn.roadmap.w5.pay

import org.tinylog.kotlin.Logger

class ProdPaymentClient : PaymentClient {
    override fun pay(amount: Int) {
        Logger.info("prod payment client pay $amount")
    }
}
