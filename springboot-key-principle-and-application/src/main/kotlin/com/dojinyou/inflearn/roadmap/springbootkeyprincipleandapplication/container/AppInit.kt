package com.dojinyou.inflearn.roadmap.springbootkeyprincipleandapplication.container

import jakarta.servlet.ServletContext

interface AppInit {
    fun onStartup(servletContext: ServletContext?)
}
