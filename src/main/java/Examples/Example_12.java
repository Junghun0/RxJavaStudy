package Examples;

import io.reactivex.subjects.ReplaySubject;

public class Example_12 {

    public void usingReplaySubject(){
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 ->" + data));
        subject.onNext("10");
        subject.onNext("20");
        subject.subscribe(data -> System.out.println("Subscriber #2 ->" + data));
        subject.onNext("30");
        subject.onComplete();

        /*
        Subscriber #1 ->10
        Subscriber #1 ->20
        Subscriber #2 ->10
        Subscriber #2 ->20
        Subscriber #1 ->30
        Subscriber #2 ->30
        */
    }
}
