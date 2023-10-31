package hellospring.core.Order;

import hellospring.core.discount.DiscountPolicy;
import hellospring.core.discount.FixDiscountPolicy;
import hellospring.core.discount.RateDiscountPolicy;
import hellospring.core.member.Member;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // DIP 원칙을 지키기 위해서 추상체에만 의존하고 구현체에는 의존하지 않도록 수정한다.
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
