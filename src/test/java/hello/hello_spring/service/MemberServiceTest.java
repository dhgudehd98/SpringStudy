package hello.hello_spring.service;

import hello.hello_spring.domain.Member;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService ;
    MemoryMemberRepository memberRepository ;

    @BeforeEach
    public void BeforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void AfterEach(){
        memberRepository.clear();
    }



    @Test
    @DisplayName("")
    //회원가입
    void join() {
        //given
        Member member = new Member();
        member.setName("dhgudehd");
        Long memberId = memberService.join(member);

        //when
        org.assertj.core.api.Assertions.assertThat(member.getId()).isEqualTo(memberId);

    }


    @Test
     void 중복회원검사() {
         //given
         Member member = new Member();
         member.setName("dhgudehd");


         Member member1 = new Member();
         member1.setName("dhgudehd");

         //when

         //tehn
         memberService.join(member);
         Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member1));
//         try {
//             memberService.join(member1);
//             fail();
//         } catch (IllegalStateException e) {
//             org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//         }

     }


    @Test
    @DisplayName("")
    void findMembers() {
        //given
        Member member = new Member();
        member.setName("dhgudehd1");
        memberService.join(member);

        Member member1 = new Member();
        member1.setName("spring1qw");
        memberService.join(member1);
        //when
        List<Member> members = memberService.findMembers();
        //tehn
        org.assertj.core.api.Assertions.assertThat(2).isEqualTo(members.size());


    }

    @Test
    @DisplayName("")
    void findOnes() {
        //given
        Member member = new Member();
        member.setName("dhgudehd");
        memberService.join(member);
        //when
        Member member1 = memberRepository.findById(member.getId()).get();
        //tehn
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(member1);

    }
}