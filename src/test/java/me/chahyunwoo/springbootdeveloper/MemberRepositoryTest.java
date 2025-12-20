package me.chahyunwoo.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers(){
        // when
        List<Member> members=memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(3);
    }
    @Sql("/insert-members.sql")
    @Test
    void getMemberById(){
        // when
        Member member=memberRepository.findById(2L).get();

        // then
        assertThat(member.getName()).isEqualTo("B");
    }

}