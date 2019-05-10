package Examples.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import sun.util.resources.ga.LocaleNames_ga;
import util.CommonUtils;
import util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class sExample_6 {

    public void convertExcecutor(){

        final int THREAD_NUM = 10;

        String[] data = {"1","3","5"};
        Observable<String> source = Observable.fromArray(data);
        Executor executor = Executors.newFixedThreadPool(THREAD_NUM);

        source.subscribeOn(Schedulers.from(executor))
                .subscribe(Log::i);
        source.subscribeOn(Schedulers.from(executor))
                .subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
