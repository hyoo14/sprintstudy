package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepositiory {
    //s-d jpa가 구현체 만들어서 등록해줌

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); // findByNameAnd OR 등등 굉장히 많음..interface이름만으로도 개발이 끝남.

}
