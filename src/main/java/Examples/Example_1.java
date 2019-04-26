package Examples;

import io.reactivex.Observable;

public class Example_1 {
    //just 함수와 데이터 인자 예제
    public void emit() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);
        System.out.println("---------------------");
    }
}
