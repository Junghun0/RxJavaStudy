package Examples;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class Example_13 {

    public void usingConnectableObservable(){

        String[] dt = {"1", "3", "5"};
        Observable<String> balls = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);

        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        source.connect();
    }
}
