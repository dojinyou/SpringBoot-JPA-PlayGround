package com.dojinyou.inflearn.library.v2

class Memory(
    val used: Long,
    val max: Long,
) {
    override fun toString(): String {
        return "Memory{used=$used, max=$max}"
    }
}
