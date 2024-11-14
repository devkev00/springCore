package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    public String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        // null값 출력 -> 스프링은 객체 생성 후 의존관계 주입을 받기 때문
        // 현재 객체 생성 시점에는 setUrl이 이뤄지지 않음
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message: " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }


    // 최신 자바 권장
    // 스프링 아닌 다른 컨테이너에서도 동작
    // 컴포넌트 스캔과도 잘 어울림 (빈을 따로 등록하지 않으므로)
    // 다만 외부 라이브러리에는 적용 불가능
    @PostConstruct
    public void init() throws Exception { // 의존관계 주입을 먼저 해주고 호출해주는 메서드
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception { // 빈이 종료될 떄 호출
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
