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
                .map(Shape::flip);
        source.subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
