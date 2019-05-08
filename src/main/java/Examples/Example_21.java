package Examples;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;
import util.CommonUtils;

public class Example_21 {

    public void usingGroupBy(){

        String[] objs = {"6","4","2-T","2","6-T","4-T"};

        Observable<GroupedObservable<String, String>> source = Observable.fromArray(objs).groupBy(CommonUtils::getShape);

        source.subscribe(obj -> {
            obj.subscribe(
                    val -> System.out.println("Group: "+ obj.getKey() + "\t Value:"+ val)
            );
        });
    }
}
