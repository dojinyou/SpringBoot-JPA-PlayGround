package com.dojinyou.inflearn.roadmap.w6

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URLDecoder
import java.net.URLEncoder

@RestController
class SampleController {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @RequestMapping("/encoding")
    fun encoding(@RequestBody request: Request): String {
        val email = URLEncoder.encode(request.email, "UTF-8")
        val decodedEmail = URLDecoder.decode(email, "UTF-8")
        logger.info("encoded email: $email")
        logger.info("decoded email: $decodedEmail")
        logger.info("request: $request")
        return request.email
    }
}

data class Request(
    val email: String,
)
