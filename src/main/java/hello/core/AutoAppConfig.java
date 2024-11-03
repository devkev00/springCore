package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component가 붙은 클래스를 스캔해서 자동으로 스프링 빈으로 등록한다.
        basePackages = "hello.core.member",
        // basePackages: 탐색할 페이지의 베이스를 지정한다. 이 패키지를 포함, 하위 패키지를 모두 탐색한다.
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // bean을 수동 등록했다.
    // 이런 경우 자동 등록 빈을 수동 등록 빈이 오버라이딩 하게 된다.
    // 하지만 이렇게 될 경우 버그 발생 시 잡기가 정말 힘들기 때문에,
    // 최근 스프링부트에서는 자동 등록 빈과 수동 등록 빈이 충돌될 시 오류를 발생하도록 정책을 변경하였다.

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository MemberRepository() {
//        return new MemoryMemberRepository();
//    }
}
