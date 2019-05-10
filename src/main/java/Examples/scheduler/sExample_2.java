package Examples.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import javafx.collections.ObservableList;
import util.CommonUtils;
import util.Log;

public class sExample_2 {

    public void usingNewThreadScheduler(){

        String[] orgs = {"1","3","5"};
        Observable.fromArray(orgs)
                .doOnNext(data -> Log.v("Original data : " + data))
                .map(data -> "<<" + data + ">>")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);
        CommonUtils.sleep(500);

        Observable.fromArray(orgs)
                .doOnNext(data -> Log.v("Original data~ ->" + data))
                .map(data -> "##" + data + "##")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);
        CommonUtils.sleep(500);

        Observable.fromArray(orgs)
                .doOnNext(data -> Log.i("test thread ->" + data))
                .map(data -> "tt " + data + " tt")
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(Log::i);

    }
}
