package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 오직 이 메서드를 통해서만 조회할 수 있고, 항상 같은 인스턴스만 반환한다
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서도 새로운 인스턴스를 생성할 수 없게 생성자를 private으로 막음
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    // 단점:
    // 싱글톤 패턴을 구현하는 코드 자체가 많이 들어감;;;
    // DIP 위반, OCP 위반
    // 테스트하기 힘듦
    // 내부 속성 변경이나 초기화가 힘듦
    // 자식 클래스 만들기 힘듦(private 생성자)
    // 결론적으로 유연성이 떨어짐
    // 하지만 스프링은 "이 모든 단점을 제거하고" 객체를 싱글톤으로 관리해준다 ㅁㅊ

}
