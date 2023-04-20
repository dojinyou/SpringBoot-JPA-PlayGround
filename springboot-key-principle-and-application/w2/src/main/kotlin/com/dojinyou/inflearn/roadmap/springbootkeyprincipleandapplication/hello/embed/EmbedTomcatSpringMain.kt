package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.hello.embed

import com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.hello.spring.HelloConfig
import org.apache.catalina.connector.Connector
import org.apache.catalina.startup.Tomcat
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class EmbedTomcatSpringMain

fun main() {
    println("EmbedTomcatSpringMain.main")

    val tomcat = Tomcat().apply {
        // tomcat 설정
        connector = Connector().apply {
            port = 8080
        }

        // 스프링 컨테이너 생성
        val appContext = AnnotationConfigWebApplicationContext().apply {
            register(HelloConfig::class.java)
        }

        // 스프링 MVC 디스패치 서블릿 생성, 컨테이너 연결
        val dispatcher = DispatcherServlet(appContext)

        // 서블릿 등록
        val context = addContext("", "/")
        addServlet("", "dispatcher", dispatcher)
        context.addServletMappingDecoded("/", "dispatcher")
    }

    tomcat.start()
}
