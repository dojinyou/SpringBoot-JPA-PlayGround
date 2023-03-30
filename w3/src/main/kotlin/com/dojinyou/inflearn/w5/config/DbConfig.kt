package com.dojinyou.inflearn.w5.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.TransactionManager
import org.tinylog.kotlin.Logger
import javax.sql.DataSource

//@Configuration
class DbConfig {

    @Bean
    fun dataSource(): DataSource {
        Logger.info("dataSource 빈 등록")
        val dataSource = HikariDataSource().apply {
            this.driverClassName = "org.h2.Driver"
            this.jdbcUrl = "jdbc:h2:mem:test"
            this.username = "sa"
            this.password = ""
        }

        return dataSource
    }

    @Bean
    fun transactionManager(): TransactionManager {
        Logger.info("transactionManager 빈 등록")
        return JdbcTransactionManager(dataSource())
    }

    @Bean
    fun jdbcTemplate(): JdbcTemplate {
        Logger.info("jdbcTemplate 빈 등록")
        return JdbcTemplate(dataSource())
    }
}
