package com.dojinyou.inflearn.w3.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(value = [SampleConfig::class])
class StaticImportConfig
