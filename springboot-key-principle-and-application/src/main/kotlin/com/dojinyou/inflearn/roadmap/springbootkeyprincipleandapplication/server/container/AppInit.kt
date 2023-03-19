package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.server.container

import jakarta.servlet.ServletContext

interface AppInit {
    fun onStartup(servletContext: ServletContext?)
}
