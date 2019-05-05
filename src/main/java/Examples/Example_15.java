package Examples;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.Scanner;

public class Example_15 {

    public void plainGugudan(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Gugudan Input");
        int dan = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= 9; ++dan) {
            System.out.println(dan + " * " + i + " = " + dan*i);
        }
    }

    public void usingFlatMap(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Gugudan Input");
        int dan = Integer.parseInt(scanner.nextLine());

        Observable<Integer> source = Observable.range(1,9);
        source.subscribe(row -> System.out.println(dan + " * " + row + " = "+ dan*row));
    }

    public void usingFlatMap2(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Gugudan Input");
        int dan = Integer.parseInt(scanner.nextLine());

        Function<Integer, Observable<String>> gugudan = num ->
                Observable.range(1,9).map(row -> num + " * " + row + " = " + num*row);
        Observable<String> source = Observable.just(dan).flatMap(gugudan);
        source.subscribe(System.out::println);
    }

    public void usingFlatMap3(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Gugudan Input");
        int dan = Integer.parseInt(scanner.nextLine());

        Observable<String> source = Observable.just(dan)
                .flatMap(num -> Observable.range(1,9))
                .map(row -> dan + " * "+ row + " = " + dan*row);
    }

    public void usingFlatMap4(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Gugudan Input");
        int dan = Integer.parseInt(scanner.nextLine());

        Observable<String> source = Observable.just(dan)
                .flatMap(gugu -> Observable.range(1,9), (gugu, i) -> gugu + " * "+i + " = "+ gugu*i);
        source.subscribe(System.out::println);
        scanner.close();
    }
}