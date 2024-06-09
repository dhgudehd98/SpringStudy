package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // store값에 찾는 id값이 존재하면 출력 / 만약 없으면 null값 출력
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //이름으로 찾는다. -> Member에 접근해서 이름이 동일한 것들만 출력
        return store.values().stream().filter(m -> m.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        //store에는 Member가 키에 대한 값으로 저장되어 있어서 출력하려면 values() 출력
        return new ArrayList<>(store.values());
    }

    public void clear(){
        store.clear();
    }
}