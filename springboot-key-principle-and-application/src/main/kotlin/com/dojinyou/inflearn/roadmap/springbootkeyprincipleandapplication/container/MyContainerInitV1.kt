package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.container

import jakarta.servlet.ServletContainerInitializer
import jakarta.servlet.ServletContext

class MyContainerInitV1 : ServletContainerInitializer {
    override fun onStartup(c: MutableSet<Class<*>>?, ctx: ServletContext?) {
        println("MyContainerInitV1.onStartup")
        println("MyContainerInitV1 c = $c")
        println("MyContainerInitV1 ctx = $ctx")
    }
}
