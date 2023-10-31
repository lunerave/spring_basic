package hellospring.core.Order;

import hellospring.core.discount.DiscountPolicy;
import hellospring.core.discount.FixDiscountPolicy;
import hellospring.core.member.Member;
import hellospring.core.member.MemberRepository;
import hellospring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
