package Examples;

import io.reactivex.Observable;

import java.util.stream.IntStream;

public class Example_3 {

    //fromArray() 를 사용해 배열에 들어 있는 데이터 처리
    public void makeFromArray(){
        Integer[] arr = {100,200,300,400};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
        System.out.println("---------------------");

        /* int[] 로 선언할 경우 -> toIntegerArray 메소드 사용
        int[] arr = {100,200,300,400};
        Observable<Integer> source = Observable.fromArray(toIntegerArray(arr));
        source.subscribe(System.out::println);
        */
    }
    private static Integer[] toIntegerArray(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }
}
