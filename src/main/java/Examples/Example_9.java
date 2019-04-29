package Examples;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

import java.nio.channels.FileLock;

public class Example_9 {

    public void usingAsyncSubject() {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("SubScriber #1 =>" + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 =>" + data));
        subject.onNext("5");
        subject.onComplete();
    }

    public void usingAsyncSubject2() {

        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.print("Subscriber #1 => "+ data));
        source.subscribe(subject);
    }

    public void usingAsyncSubject3(){

        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);
        subject.subscribe(data -> System.out.println("Subscriber #1 =>" + data));
        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(data -> System.out.println("Subscriber #2 =>" + data));
        subject.subscribe(data -> System.out.println("Subscriber #3 =>" + data));
    }
}
