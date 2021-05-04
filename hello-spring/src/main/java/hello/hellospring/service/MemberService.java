package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositiory;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepositiory memberRepositiory;


    public MemberService(MemberRepositiory memberRepositiory) {
        this.memberRepositiory = memberRepositiory;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원 x
        validateDuplicateMember(member); //중복회원검증
        memberRepositiory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepositiory.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /*
    * 전체회원조회
    * */
    public List<Member> findMembers(){
        return memberRepositiory.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepositiory.findById(memberId);
    }
}
