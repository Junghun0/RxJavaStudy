package Examples;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class Example_14 {
    //리액티브 연산자 사용해보기
    public void usingMap(){

        Function<String, Integer> ballToIndex = ball -> {
            switch (ball){
                case "RED" : return 1;
                case "YELLOW" : return 2;
                case "GREEN" : return 3;
                case "BLUE" : return 4;
                default: return -1;
            }
        };

        String[] balls = {"RED","YELLOW","GREEN","BLUE"};
        Observable<Integer> source = Observable.fromArray(balls)
                .map(ballToIndex);
        source.subscribe(System.out::println);
    }
}
