package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 얘네의 단점: 스프링 무조건 써야 함, 메서드 이름 변경 안됨, 외부 라이브러리에 적용 불가능 (현재는 거의 사용 x)
public class NetworkClient implements InitializingBean, DisposableBean {
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

    @Override
    public void afterPropertiesSet() throws Exception { // 의존관계 주입을 먼저 해주고 호출해주는 메서드
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception { // 빈이 종료될 떄 호출
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
