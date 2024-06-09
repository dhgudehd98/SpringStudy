package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {
   MemoryMemberRepository memberRepository= new MemoryMemberRepository();

    @AfterEach
    void AfterEach(){
        memberRepository.clear();
    }


    @Test
    @DisplayName("저장")
    void save() {
        //given
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);
        //when
        Member result = memberRepository.findById(member.getId()).get();
        //then
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    @DisplayName("")
    void findById() {
        //given
        Member member = new Member();
        member.setName("spring111");
        memberRepository.save(member);

        Member member1 = new Member();
        member.setName("spring222");

        memberRepository.save(member);
        //when
        Member member2 = memberRepository.findById(member.getId()).get();
        //then
        Assertions.assertThat(member).isEqualTo(member2);

    }

    @Test
    @DisplayName("")
    void findByName() {
        //given
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);
        //when
        Member member3 = memberRepository.findByName(member.getName()).get();
        //tehn
        Assertions.assertThat(member).isEqualTo(member);

    }

    @Test
    @DisplayName("")
    void findAll() {
        //given
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);
        //when
        List<Member> all = memberRepository.findAll();
        //tehn
        //값을 2개만 저장해놔서 list의 size는 2
        Assertions.assertThat(2).isEqualTo(all.size());

    }
}