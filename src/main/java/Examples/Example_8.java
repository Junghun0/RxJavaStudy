package Examples;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Example_8 {

    public void usingSingle(){

        //1.기존 Observable 에서 Single 객체로 변환하기
        Observable<String> source = Observable.just("Hello Single!");
        Single.fromObservable(source).subscribe(System.out::println);

        //2. single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello Single!")
                .single("default Item")
                .subscribe(System.out::println);

        //3. first() 함수를 호출해 Single 객체 생성하기
        String[] colors = {"Red","Blue","Gold"};
        Observable.fromArray(colors)
                .first("default value")
                .subscribe(System.out::println);

        //4. empty Observable 에서 Single 객체 생성하기
        Observable.empty()
                .single("default value")
                .subscribe(System.out::println);

        //5. take() 함수에서 Single 객체 생성하기
        Observable.just(new Order("Order_1"),new Order("Order_2"))
                .take(1)
                .single(new Order("default order"))
                .subscribe(System.out::println);
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
}

