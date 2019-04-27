package Examples;


import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.concurrent.Callable;

public class Example_5 {

    //람다 표현식을 사용할 때
    public void usingCallable() {

        Callable<String> callable = () -> {
            Thread.sleep(2000);
            return "Hello callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }

    //람다 표현식을 사용하지 않을때
    public void usingCallable2() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Hello callable2";
            }
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }
}
