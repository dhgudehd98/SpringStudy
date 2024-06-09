package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService
{
    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     * - 같은 이름 중복 X - id값 반환 시킬 수 있또록
     * 전체 회원 조회(findMembers)
     * 멤버 하나 찾기(findOne)
     */
    //회원가입
    public Long join(Member member) {

        //같은 이름 중복 제외 - 리포지토리에서 확인해야겟지 ?
        validateName(member);
        memberRepository.save(member);
        return member.getId();
    }

    //아이디 중복 제외 - 리포지토리에서 확인 해야함 .
    private void validateName(Member member) {
        Optional<Member> byName = memberRepository.findByName(member.getName());
        byName.ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }
        );
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //멤버 한명 찾기 -> id로 찾기 or 이름으로 찾기
    public Optional<Member> findOnes(Long MemberId){
        return memberRepository.findById(MemberId);
    }

//    public Optional<Member> findOnes(String name){
//        return memberRepository.findByName(name);
//    }

}