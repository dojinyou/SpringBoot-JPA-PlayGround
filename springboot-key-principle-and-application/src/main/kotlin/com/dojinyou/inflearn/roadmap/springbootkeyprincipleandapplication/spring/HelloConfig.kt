package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class HelloConfig {

    @Bean
    open fun helloController() = HelloController()
}
