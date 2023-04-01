package com.dojinyou.inflearn.w3.config

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.TransactionManager
import org.tinylog.kotlin.Logger
import javax.sql.DataSource

@SpringBootTest
class DbConfigTest {

    @Autowired
    lateinit var dataSource: DataSource

    @Autowired
    lateinit var transactionManager: TransactionManager

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun checkBean() {
        Logger.info("dataSource = $dataSource")
        Logger.info("transactionManager = $transactionManager")
        Logger.info("jdbcTemplate = $jdbcTemplate")

        Assertions.assertThat(dataSource).isNotNull
        Assertions.assertThat(transactionManager).isNotNull
        Assertions.assertThat(jdbcTemplate).isNotNull
    }
}
