package Examples.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;

public class sExample_5 {

    public void usingSingleThread(){

        //싱글 스레드 스케줄러는 RxJava 내부에서 단일 스레드를 별도로 생성하여 구독작업을 처리한다.
        //단, 생성된 스레드는 여러 번 구독 요청이 와도 공통으로 사용한다.

        Observable<Integer> numbers = Observable.range(100,5);
        Observable<String> chars = Observable.range(0,5)
                .map(CommonUtils::numberToAlphabet);

        numbers.subscribeOn(Schedulers.single())
                .subscribe(Log::i);
        chars.subscribeOn(Schedulers.single())
                .subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
