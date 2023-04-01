package com.dojinyou.inflearn.library.v1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.tinylog.kotlin.Logger

@RestController
class MemoryController(
    private val memoryFinder: MemoryFinder,
) {

    @GetMapping("/memory")
    fun system(): Memory {
        val memory = memoryFinder.get()

        Logger.info(memory)
        return memory
    }
}
