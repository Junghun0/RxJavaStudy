package Examples;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class Example_17 {

    public void usingReduce() {
        String[] balls = {"1", "3", "5"};
        Maybe<String> source = Observable.fromArray(balls)
                .reduce((ball1, ball2) -> ball2 + "(" + ball1 + ")");
        source.subscribe(System.out::println);
    }
}
