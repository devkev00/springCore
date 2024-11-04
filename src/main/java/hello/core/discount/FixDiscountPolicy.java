package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component 
// 현재 Component 어노테이션을 지정 -> AutoAppConfig의 로직 때문에 의존관계 자동 주입 -> Bean이 두 개 등록되는 문제 발생
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 천원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
