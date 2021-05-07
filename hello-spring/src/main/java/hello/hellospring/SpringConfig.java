package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration //이거 읽고 스프링 빈에 등록해야겠네? 하고 등록해줌
public class SpringConfig {


//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    //아래는 jap용 상기는 다른 용(jdbc template등)
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }


    //s-d jpa용
    private final MemberRepositiory memberRepositiory;
    @Autowired //생성자 하나니까 생략해도 됨
    public SpringConfig(MemberRepositiory memberRepositiory) {
        this.memberRepositiory = memberRepositiory;
    }



    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepositiory);
    }

//    @Bean //이렇게 해주거나 컴포즈 스캔? 써도 됨.. 여기서는 컴포즈 스캔(Component) 쓰지만 일반적으로는 빈등록이 더 많이 씀
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepositiory memberRepositiory(){
//        //조립해줌!
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//
//
//    }
}
