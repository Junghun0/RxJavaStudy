package Examples;

import io.reactivex.Observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example_6 {

    public void usingFuture(){

        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(1000);
            return "Hello Future";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(System.out::println);
    }
}
