import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        new Main().emit();
    }

    public void emit(){
        Observable.just("Hello","RxJava2!!")
                .subscribe(System.out::println);
    }
}
