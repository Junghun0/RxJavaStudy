package Examples;

import io.reactivex.subjects.AsyncSubject;

public class Example_9 {

    public void usingAsyncSubject(){

        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("SubScriber #1 =>"+data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 =>"+ data));
        subject.onNext("5");
        subject.onComplete();
    }
}
