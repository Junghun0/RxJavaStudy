package Examples;

import io.reactivex.Observable;
import util.CommonUtils;
import util.Log;

import java.util.concurrent.TimeUnit;

public class Example_18 {

    public void usingInterval(){

        CommonUtils.exampleStart();

        Observable<Long> source = Observable.interval(100L , TimeUnit.MILLISECONDS)
                .map(data -> (data + 1) * 100)
                .take(5);
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}

