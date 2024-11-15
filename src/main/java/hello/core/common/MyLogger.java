    package hello.core.common;

    import jakarta.annotation.PostConstruct;
    import jakarta.annotation.PreDestroy;
    import org.springframework.context.annotation.Scope;
    import org.springframework.context.annotation.ScopedProxyMode;
    import org.springframework.stereotype.Component;

    import java.util.UUID;

    @Component
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    // CGLIB으로 가짜 프록시 객체를 만들어서 주입
    // 이 객체에는 실제 빈을 요청하는 위임 로직이 들어 있음
    // 싱글톤처럼 동작하지만, 실제로는 각 요청마다 새로운 빈이 생성됨

    public class MyLogger {

        private String uuid;
        private String requestURL;

        public void setRequestURL(String requestURL) {
            this.requestURL = requestURL;
        }

        public void log(String message) {
            System.out.println("[" + uuid + "] " + "[" + requestURL + "] " + message);
        }

        @PostConstruct
        public void init() {
            uuid = UUID.randomUUID().toString();
            System.out.println("[" + uuid + "] request scope bean create: " + this);
        }

        @PreDestroy
        public void close() {
            System.out.println("[" + uuid + "] request scope bean close: " + this);
        }
    }
