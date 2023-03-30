package com.dojinyou.inflearn.w5.config

import com.dojinyou.inflearn.MemoryController
import com.dojinyou.inflearn.MemoryFinder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MemoryConfig {

    @Bean
    fun memoryController(): MemoryController {
        return MemoryController(memoryFinder())
    }

    @Bean
    fun memoryFinder(): MemoryFinder {
        return MemoryFinder()
    }
}
