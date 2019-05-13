import Examples.scheduler.Network.CallbackHeaven;
import Examples.scheduler.Network.CallbackHell;
import Examples.scheduler.Network.Scheduler_Network_Sample;

public class Main {
    public static void main(String[] args) {
//        new Example_1().emit();
//        new Example_2().usingIsDisposed();
//        new Example_3().makeFromArray();
//        new Example_4().makeIterator();
//        new Example_4().usingBlockingQueue();
//        new Example_5().usingCallable();
//        new Example_6().usingFuture();
//        new Example_8().usingSingle();
//        new Example_9().usingAsyncSubject();
//        new Example_9().usingAsyncSubject2();
//        new Example_9().usingAsyncSubject3();
//        new Example_10().usingBehaviorSubject();
//        new Example_11().usingPublishSubject();
//        new Example_12().usingReplaySubject();
//        new Example_14().usingMap();
//        new Example_15().usingFlatMap();
//        new Example_19().usingConcatMap();
//        new Example_19().usingConcatMap2();
//        new Example_21().usingGroupBy();
//        new sExample_1().usingScheduler1();
//        new sExample_1().usingScheduler2();
//        new sExample_2().usingNewThreadScheduler();
//        new sExample_6().convertExcecutor();
//        new Scheduler_Network_Sample().run();
//        new CallbackHell().run();
        new CallbackHeaven().usingZip();
        new CallbackHeaven().usingConcat();
    }
}
