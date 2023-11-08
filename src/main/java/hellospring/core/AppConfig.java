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

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
