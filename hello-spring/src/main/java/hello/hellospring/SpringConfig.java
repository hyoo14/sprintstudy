package hello.hellospring;

import hello.hellospring.repository.MemberRepositiory;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //이거 읽고 스프링 빈에 등록해야겠네? 하고 등록해줌
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepositiory());
    }

    @Bean
    public MemberRepositiory memberRepositiory(){
        return new MemoryMemberRepository();
    }
}
