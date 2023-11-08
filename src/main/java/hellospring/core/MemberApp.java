package hellospring.core;

import hellospring.core.member.Grade;
import hellospring.core.member.Member;
import hellospring.core.member.MemberService;
import hellospring.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // Transform Java code into Spring code
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new member = " + member.getName());

    }
}
