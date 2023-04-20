package com.dojinyou.inflearn.library.v1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MemoryFinderTest {

    @Test
    fun getTest() {
        val memoryFinder = MemoryFinder()
        val memory = memoryFinder.get()

        Assertions.assertThat(memory).isNotNull
    }
}
