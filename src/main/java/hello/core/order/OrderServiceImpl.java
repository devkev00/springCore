package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // DIP 원칙 위반, 인터페이스뿐이 아닌 구현체에도 의존하고 있다.
    private DiscountPolicy discountPolicy;
    // 이렇게 하면 DIP 원칙은 지켜지지만, 구현체가 없으므로 NPE가 발생
    // 따라서 의존성을 따로 주입해주는 역할을 하는 '누군가' 가 필요하다!

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
