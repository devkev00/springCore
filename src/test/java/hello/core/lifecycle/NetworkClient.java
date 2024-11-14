package hello.core.lifecycle;

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
}
