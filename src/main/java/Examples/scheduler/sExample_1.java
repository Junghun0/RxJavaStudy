package Examples.scheduler;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;
import util.Shape;

public class sExample_1 {

    public void usingScheduler1(){
        Observable.just("Hello","RxJava2!!!!")
                .subscribe(Log::i);
    }

    public void usingScheduler2(){
        String[] objs = {"1-S","2-T","3-P"};
        Observable<String> source = Observable.fromArray(objs)
                .doOnNext(data -> Log.v("Original data -> " + data))
                .subscribeOn(Schedulers.newThread())//subscribe() 호출하여 구독할 때 실행되는 스레드를 지정한다.
                .observeOn(Schedulers.newThread())//Observable에서 생성한 데이터 흐름이 여기저기 함수를 거치며 처리될때 동작이 어느 스레드에서 일어나는지 지정할 수 있다.
                .map(Shape::flip);//최초의 데이터 흐름이 발생하는 스레드와 flip()함수를 거쳐서 구독자에게 전달되는 스레가 다르다.
        //만약 observeOn() 함수를 지정하지 않으면 subscribeOn() 함수로 지정한 스레드에서 모든 로직을 실행
        source.subscribe(Log::i);
        CommonUtils.sleep(500);

        /*
        1. 스케줄러는 RxJava 코드를 어느 스레드에서 실행할지 지정할 수 있다.
        2. subscribeOn() 함수와 observeOn() 함수를 모두 지정하면 Observable에서 데이터 흐름이 발생하는 스레드와
           처리된 결과를 구독자에게 발행하는 스레드를 분리할 수 있다.
        3. subscribeOn() 함수만 호출하면 Observable의 모든 흐름이 동일한 스레드에서 실행된다.
        4. 스케줄러를 별도로 지정하지 않으면 현재(main) 스레드에서 동작을 실행한다.
        */
    }
}
