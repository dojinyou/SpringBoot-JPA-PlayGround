package com.dojinyou.inflearn.memory

import jakarta.annotation.PostConstruct
import org.tinylog.kotlin.Logger

class MemoryFinder {

    fun get(): Memory {
        val max = Runtime.getRuntime().maxMemory()
        val total = Runtime.getRuntime().totalMemory()
        val free = Runtime.getRuntime().freeMemory()
        val used = total - free

        return Memory(used = used, max = max)
    }

    @PostConstruct
    fun init() {
        Logger.info("init MemoryFinder")
    }
}
