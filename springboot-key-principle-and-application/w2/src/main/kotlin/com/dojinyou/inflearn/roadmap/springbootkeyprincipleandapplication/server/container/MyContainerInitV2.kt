package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.server.container

import jakarta.servlet.ServletContainerInitializer
import jakarta.servlet.ServletContext
import jakarta.servlet.annotation.HandlesTypes
import java.lang.RuntimeException

@HandlesTypes(AppInit::class)
class MyContainerInitV2 : ServletContainerInitializer {
    override fun onStartup(c: MutableSet<Class<*>>?, ctx: ServletContext?) {
        println("MyContainerInitV2.onStartup")
        println("MyContainerInitV2 c = $c")
        println("MyContainerInitV2 ctx = $ctx")

        for (appInitClass in c!!) {
            try {
                val appInit = appInitClass.getDeclaredConstructor().newInstance() as AppInit
                appInit.onStartup(ctx)
            } catch (e: Exception) {
                throw RuntimeException()
            }
        }
    }
}
