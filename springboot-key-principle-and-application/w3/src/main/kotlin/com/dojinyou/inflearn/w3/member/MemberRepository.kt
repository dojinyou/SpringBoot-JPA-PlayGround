package com.dojinyou.inflearn.w3.member

import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class MemberRepository(
    val jdbcTemplate: JdbcTemplate,
) {

    fun initTable() {
        jdbcTemplate.execute("create table member(member_id varchar primary key, name varchar)")
    }

    fun save(member: Member) {
        jdbcTemplate.update("insert into member(member_id, name) values ('${member.memberId}', '${member.name}')")
    }

    fun findById(memberId: String): Member? {
        return jdbcTemplate.queryForObject("select member_id, name from member where member_id = ?", memberId) {
                rs: ResultSet, _: Int ->
            Member(rs.getString("member_id"), rs.getString("name"))
        }
    }

    fun findAll(): List<Member> {
        return jdbcTemplate.query(
            "select member_id, name from member",
            BeanPropertyRowMapper.newInstance(Member::class.java),
        )
    }
}
