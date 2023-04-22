package com.dojinyou.inflearn.roadmap.w5.config

import com.dojinyou.inflearn.roadmap.w5.datasource.MyDataSource
import com.dojinyou.inflearn.roadmap.w5.datasource.MyDataSourcePropertiesV2
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.tinylog.kotlin.Logger

@EnableConfigurationProperties(MyDataSourcePropertiesV2::class)
class MyDataSourceConfigV2(
    private val properties: MyDataSourcePropertiesV2,
) {

    @Bean
    fun dataSource(): MyDataSource {
        Logger.info(this.javaClass.simpleName)
        return MyDataSource(
            url = properties.url,
            username = properties.username,
            password = properties.password,
            maxConnection = properties.etc.maxConnection,
            timeout = properties.etc.timeout,
            options = properties.etc.options,
        )
    }
}
