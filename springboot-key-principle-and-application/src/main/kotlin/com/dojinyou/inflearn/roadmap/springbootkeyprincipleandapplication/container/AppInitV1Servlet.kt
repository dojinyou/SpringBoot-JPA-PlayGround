package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.container

import com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.servlet.HelloServlet
import jakarta.servlet.ServletContext

class AppInitV1Servlet : AppInit {
    override fun onStartup(servletContext: ServletContext?) {
        println("AppInitV1Servlet.onStartup: start")

        // 순수 서블릿 코드 등록
        val helloServlet = servletContext?.addServlet("helloServlet", HelloServlet())
        helloServlet?.addMapping("/test-v2")

        println("AppInitV1Servlet.onStartup: end")
    }
}
