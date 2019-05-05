package Examples;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Example_16 {

    public void usingFilter() {

        Integer[] data = {100, 34, 27, 99, 50};
        Observable<Integer> source = Observable.fromArray(data)
                .filter(number -> number % 2 == 0);
        source.subscribe(System.out::println);
    }

    public void usingFilterMethod() {
        Integer[] numbers = {100, 200, 300, 400, 500};
        Single<Integer> single;
        Observable<Integer> source;

        //1.first -> Observable의 첫 번째 값을 필터함
        single = Observable.fromArray(numbers).first(-1);
        single.subscribe(data -> System.out.println("first() value = " + data));

        //2.last -> Observable의 마지막 값을 필터함
        single = Observable.fromArray(numbers).last(999);
        single.subscribe(data -> System.out.println("last() value = " + data));

        //3.take(N) -> 최초의 N개 값을 가져옴
        source = Observable.fromArray(numbers).take(3);
        source.subscribe(data -> System.out.println("take(3) values = " + data));

        //4.takeLast(N) -> 마지막 N개만 필터함
        source = Observable.fromArray(numbers).takeLast(3);
        source.subscribe(data -> System.out.println("takeLast(3) values = " + data));

        //5.skip(N) -> 최초의 N개 건너띔
        source = Observable.fromArray(numbers).skip(2);
        source.subscribe(data -> System.out.println("skip(2) values = " + data));

        //6.skipLast(N) -> 마지막 N개 건너띔
        source = Observable.fromArray(numbers).skipLast(2);
        source.subscribe(data -> System.out.println("skipLast(2) values = " + data));
    }
}