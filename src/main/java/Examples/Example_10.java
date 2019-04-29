package Examples;

import io.reactivex.subjects.BehaviorSubject;

public class Example_10 {

    public void usingBehaviorSubject(){
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
        subject.subscribe(data -> System.out.println("Subscriber #1 =>" + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 =>" + data));
        subject.onNext("5");
        subject.onComplete();

/*
Subscriber #1 =>6
Subscriber #1 =>1
Subscriber #1 =>3
Subscriber #2 =>3
Subscriber #1 =>5
Subscriber #2 =>5
*/
    }
}
