package com.dojinyou.inflearn.w3.member

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Transactional
    @Test
    fun memberTest() {
        val memberId = "idA"
        val name = "memberA"
        memberRepository.initTable()
        memberRepository.save(Member(memberId, name))

        val findMember = memberRepository.findById(memberId)!!

        Assertions.assertThat(findMember.memberId).isEqualTo(memberId)
        Assertions.assertThat(findMember.name).isEqualTo(name)
    }
}
