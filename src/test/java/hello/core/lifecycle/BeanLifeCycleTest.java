package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig {

        @Bean(initMethod = "init", destroyMethod = "close")
        // 메서드 이름 자유로움, 스프링에 의존 x, 외부 라이브러리에도 적용 가능(코드가 아니라 설정 정보이기 때문)
        // destroyMethod는 기본값이 inferred(추론) -> close, shutdown 등의 메서드를 자동으로 호출
        // 즉 종료 메서드를 추론해서 자동으로 호출(종료 메서드를 따로 적어주지 않아도 되는 이유)
        // 추론 안하고 싶으면 destroyMethod=""
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
