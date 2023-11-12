package hellospring.core;

import hellospring.core.Order.OrderService;
import hellospring.core.Order.OrderServiceImpl;
import hellospring.core.discount.DiscountPolicy;
import hellospring.core.discount.FixDiscountPolicy;
import hellospring.core.discount.RateDiscountPolicy;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemberService;
import hellospring.core.member.MemberServiceImpl;
import hellospring.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration이 없다면 스프링 컨테이너가 더 이상 싱글톤을 적용하지 않고 순수 자바 코드 로직으로 프로그램이 작동한다
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository(), .. 두번 콜이 되는데 싱글톤이 깨지는가?

    //실제로 콜 테스트를 돌려봄

    //예측
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository
    //call AppConfig.discountPolicy

    //실제
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.discountPolicy
    //스프링 컨테이너가 스스로 싱글톤 패턴 기능을 해주고 있는지 확인할 수 있다
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
