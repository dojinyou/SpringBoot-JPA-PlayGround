package com.dojinyou.inflearn

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import org.tinylog.kotlin.Logger

class MemoryCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        // -Dmemory=on
        val memory = context.environment.getProperty("memory")
        Logger.info("Memory={$memory}")
        return memory.equals("ON", ignoreCase = true)
    }
}
