package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제! (여러 쓰레드가 동시에 접근하면 값이 덮어써짐)
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
