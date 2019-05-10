package Examples.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;

import java.io.File;

public class sExample_3 {

    public void usingIOScheduler(){
        String root = "C:\\";
        File[] files = new File(root).listFiles();
        Observable<String> source = Observable.fromArray(files)
                .filter(f -> !f.isDirectory())
                .map(f -> f.getAbsolutePath())
                .subscribeOn(Schedulers.io());
        source.subscribe(Log::i);
        CommonUtils.sleep(500);
    }
}
