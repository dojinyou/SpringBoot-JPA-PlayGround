package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.server.container

import com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.server.spring.HelloController
import jakarta.servlet.ServletContext
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class AppInitV2Spring : AppInit {
    override fun onStartup(servletContext: ServletContext?) {
        println("AppInitV2Spring.onStartup")

        // 스프링 컨테이너 생성
        val appContext = AnnotationConfigWebApplicationContext()
        appContext.register(HelloController::class.java)

        // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
        val dispatcherServlet = DispatcherServlet(appContext)

        // 디스패처 서블릿을 서블릿 컨테이너에 등록
        val servlet = servletContext?.addServlet("dispatcherV2", dispatcherServlet)
        servlet?.addMapping("/spring/*")
    }
}
