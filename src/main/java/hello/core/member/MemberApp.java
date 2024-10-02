package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        
        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);

        Member findMember = memberService.findMember(1L);
        System.out.println("find member = " + findMember.getName());
        System.out.println("new member = " + member.getName());


    }
}
