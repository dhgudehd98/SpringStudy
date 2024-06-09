package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /**
     * 1. 저장(save)
     * 2. 아이디 찾기(findById)
     * 3. 이름 찾기(findByName)
     * 4. 모든 목록 죟 findAll
     *
     * @param id
     * @return
     */
    //1. Member 저장
    Member save(Member member);
    //2. 아이디 찾기
    Optional<Member> findById(Long id);

    //3. 이름 찾기
    Optional<Member> findByName(String name);
    //4. 모든 목록 조회
    List<Member> findAll();
}
