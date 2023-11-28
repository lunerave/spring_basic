package hellospring.core.discount;

import hellospring.core.annotation.MainDiscountPolicy;
import hellospring.core.member.Grade;
import hellospring.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
//@Primary //searched Bean이 2개 이상일 때 우선 순위를 지정해준다
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
