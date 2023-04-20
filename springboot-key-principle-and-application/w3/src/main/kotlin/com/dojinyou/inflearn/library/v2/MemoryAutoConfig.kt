package com.dojinyou.inflearn.library.v2

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnProperty(name = ["memory"], havingValue = "on")
class MemoryAutoConfig {

    @Bean
    fun memoryController(): MemoryController {
        return MemoryController(memoryFinder())
    }

    @Bean
    fun memoryFinder(): MemoryFinder {
        return MemoryFinder()
    }
}
