package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.hello.embed

import com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.hello.servlet.HelloServlet
import org.apache.catalina.connector.Connector
import org.apache.catalina.startup.Tomcat

class EmbedTomcatServletMain

fun main() {
    println("EmbedTomcatServletMain.main")

    val tomcat = Tomcat().apply {
        // tomcat 설정
        connector = Connector().apply {
            port = 8080
        }

        // 서블릿 등록
        val context = addContext("", "/")
        addServlet("", "helloServlet", HelloServlet())
        context.addServletMappingDecoded("/hello-servlet", "helloServlet")
    }

    tomcat.start()
}
