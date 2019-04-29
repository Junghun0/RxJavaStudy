package Examples;

import io.reactivex.subjects.PublishSubject;

public class Example_11 {

    public void usingPublishSubject(){

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 =>" + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 =>" + data));
        subject.onNext("5");
        subject.onComplete();

        /*
        Subscriber #1 =>1
        Subscriber #1 =>3
        Subscriber #1 =>5
        Subscriber #2 =>5
         */
    }
}
