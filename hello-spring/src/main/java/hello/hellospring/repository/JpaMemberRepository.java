package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepositiory{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }



    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    //조회 업데이트 딜리트 sql짤 필요 없다 다 자동으로 됨
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //객체 대상으로 쿼리 날림
                .getResultList(); //inline ctrl+alt+N //찾기(검색)는 ctrl+alt+shitf+T

    }
}
