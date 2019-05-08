package Examples;

import io.reactivex.Observable;
import util.CommonUtils;
import util.Log;

import java.util.concurrent.TimeUnit;

public class Example_19 {

    public void usingConcatMap() {

        //시간을 측정하기 위해 호출
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        //100ms 간격으로 interval() 함수를 호출한 후
        Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                //0부터 발행하는 Long 객체 값을 Integer 객체 값으로 변환
                .map(Long::intValue)
                //숫자를 1, 3, 5 문자열로 변환함
                .map(idx -> balls[idx])
                //3개를 가져옴
                .take(balls.length)
                .concatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball + "#")
                        .take(3));
        source.subscribe(Log::it);
        CommonUtils.sleep(2000);
    }

    //concatMap() 함수를 flatMap()함수로 변경
    public void usingConcatMap2(){
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .flatMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball + "#")
                        .take(2));
        source.subscribe(Log::it);
        CommonUtils.sleep(2000);
    }
}
