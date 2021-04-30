package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;

//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        //setter injection 3방법, 단점: 누군가가 멤버 컨트롤러 호출시 퍼블릭하게 노출. 중간에 잘못 바꾸면 문제
//        this.memberService = memberService;
//    }

    //@Autowired private MemberService memberService; //2번째 방법 _ 필드 주입

    @Autowired
    public MemberController(MemberService memberService) {
        //요즘권장. 생성시점에 딱 넣고 그 다음에는 변경 못 하도록 막을 수 있음
        //생성자 주입 방법..1번째 방법
        this.memberService = memberService;
    }

}
