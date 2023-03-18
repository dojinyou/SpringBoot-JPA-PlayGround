package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.servlet

import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class HelloServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("HelloServlet.service")
        resp!!.writer.println("Hello Servlet!")
    }
}
