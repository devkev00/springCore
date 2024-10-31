package hello.core;

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

}
