package com.dojinyou.inflearn.roadmap.w5.config

import com.dojinyou.inflearn.roadmap.w5.datasource.MyDataSource
import com.dojinyou.inflearn.roadmap.w5.datasource.MyDataSourcePropertiesV1
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@EnableConfigurationProperties(MyDataSourcePropertiesV1::class)
class MyDataSourceConfigV1(
    private val properties: MyDataSourcePropertiesV1,
) {

    @Bean
    fun dataSource(): MyDataSource {
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
