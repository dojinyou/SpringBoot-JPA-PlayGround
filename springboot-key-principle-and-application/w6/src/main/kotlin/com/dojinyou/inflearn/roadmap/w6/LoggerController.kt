package com.dojinyou.inflearn.roadmap.w6

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoggerController {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @RequestMapping("/log")
    fun log(): String {
        logger.trace("trace log")
        logger.debug("debug log")
        logger.info("info log")
        logger.warn("warn log")
        logger.error("error log")
        return "OK"
    }
}
