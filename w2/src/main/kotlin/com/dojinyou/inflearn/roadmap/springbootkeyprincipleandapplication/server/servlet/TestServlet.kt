package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.server.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

/**
 * http://localhost:8080/test
 */
@WebServlet(urlPatterns = ["/test"])
class TestServlet : HttpServlet() {

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("TestServlet.service")
        resp!!.writer.println("test")
    }
}
