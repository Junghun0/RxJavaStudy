package Examples;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Example_4 {

    //List 객체에서 Observable 만드는 방법
    public void makeIterator(){
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Observable<String> source = Observable.fromIterable(names);
        System.out.println(source.subscribe().isDisposed());
        source.subscribe(System.out::println);
        System.out.println(source.subscribe().isDisposed());
        System.out.println("---------------------");
    }

    //BlockingQueue 인터페이스의 객체로 Observable 만드는 방법
    public void usingBlockingQueue(){
        BlockingQueue<Order> orderBlockingQueue = new ArrayBlockingQueue<>(100);
        orderBlockingQueue.add(new Order("ORD-1"));
        orderBlockingQueue.add(new Order("ORD-2"));
        orderBlockingQueue.add(new Order("ORD-3"));

        Observable<Order> observable = Observable.fromIterable(orderBlockingQueue);
        observable.subscribe(order -> System.out.println(order.getmId()));
        System.out.println("---------------------");
    }
}


class Order{
    public String mId;

    public Order(String mId) {
        this.mId = mId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "mId='" + mId + '\'' +
                '}';
    }
}
