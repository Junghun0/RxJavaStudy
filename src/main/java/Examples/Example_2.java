package Examples;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Example_2 {
    //isDisposed() 함수 활용
    public void usingIsDisposed(){
        Observable<String> source = Observable.just("RED","GREEN","YELLOW","BLUE");

        Disposable disposable = source.subscribe(
                v -> System.out.println("onNext() : value :" + v),
                err -> System.err.println("onError() : err :" + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println("isDisposed() : "+ disposable.isDisposed());
        System.out.println("---------------------");
    }
}
