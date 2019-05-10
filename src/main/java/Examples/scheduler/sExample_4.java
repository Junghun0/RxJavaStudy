package Examples.scheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import util.CommonUtils;
import util.Log;

public class sExample_4 {

    public void usingTrampolineSchedulers() {

        //트램펄린 스케줄러는 새로운 스레드를 생성하지않고 현재 스레드에 무한한 크기의 대기 행렬(큐)를 생성하는 스케줄러이다.
        //큐에 작업을 넣은 후 1개씩 꺼내어 동작하므로 첫 번째 구독과 두 번째 구독의 실행 순서가 바뀌는 경우는 발생하지 않는다.
        String[] orgs = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(orgs);

        //구독1
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "<<" + data +  ">>")
                .subscribe(Log::i);

        //구독2
        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "<<" + data +  ">>")
                .subscribe(Log::i);

        CommonUtils.sleep(500);
    }
}
