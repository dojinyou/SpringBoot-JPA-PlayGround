package com.dojinyou.inflearn.w4.external

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.DefaultApplicationArguments

class JavaSystemProperties

fun main(args: Array<String>) {
    println("start")
    val properties = System.getProperties()
    for (key in properties.keys) {
        println("prop $key = ${properties[key]}")
    }

    for (arg in args) {
        println("args $arg")
    }

    val appArgs: ApplicationArguments = DefaultApplicationArguments(*args)
    println("SourceArgs = ${appArgs.sourceArgs.toList()}")
    println("NotOptionArgs = ${appArgs.nonOptionArgs}")
    println("OptionArgs = ${appArgs.optionNames}")

    val optionNames = appArgs.optionNames
    for (optionName in optionNames) {
        println("option arg $optionName = ${appArgs.getOptionValues(optionName)}")
    }

    println("end")
}
