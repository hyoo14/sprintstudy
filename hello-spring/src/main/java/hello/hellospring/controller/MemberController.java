package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.println("memberService = "+memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        //System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute( "members", members);
        return "members/memberList";
    }

}
