import Examples.Example_1;
import Examples.Example_2;
import Examples.Example_3;
import Examples.Example_4;

public class Main {
    public static void main(String[] args) {
        new Example_1().emit();
        new Example_2().usingIsDisposed();
        new Example_3().makeFromArray();
        new Example_4().makeIterator();
        new Example_4().usingBlockingQueue();

    }
}
