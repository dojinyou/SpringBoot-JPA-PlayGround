package com.dojinyou.inflearn.w3

import jakarta.annotation.PostConstruct
import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

@Component
class CommandLineBean(private val arguments: ApplicationArguments) {
}
