# RxJavaStudy

## Observable Class

 - Observable 은 Observer Pattern 을 구현
 - Observer Pattern 은 객체의 상태 변화를 관찰하는 관찰자(Observer) 목록을 객체에 등록한다.
 - 상태 변화가 있을 때마다 메서드를 호출하여 객체가 직접 목록의 각 Observer에게 변화를 알린다.
 - Life Cycle 은 존재하지 않으며 보통 단일 함수를 통해 변화만 알린다.

- - -
### Observable의 세 가지 알림
1. **onNext** : Observable이 데이터의 발행을 알린다. 기존의 Observer Pattern 과 동일함
2. **onComplete** : 모든 데이터의 발행을 완료했음을 알린다. onComplete 이벤트는 단 한번만 발생하며, 발생한 후에는 더 이상 onNext 이벤트가 발생하면 안된다.
3. **onError** : Observable 에서 어떤 이유로 에러가 발생했음을 알린다. onError 이벤트가 발생하면 이후에 onNext 및 onComplete 이벤트는 발생하지 않는다. 즉, Observable의 실행을 종료

### just() 함수
 - 인자로 넣은 데이터를 차례로 발행하려고 Observable을 생성
 - 한 개의 값을 넣을 수도 있고 인자로 최대 10개를 넣을 수 있다.
 - 단 타입은 모두 같아야 한다.
 
 ```java
 Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);
 ```
 - 모든 데이터 발행이 완료되면 onComplete 이벤트 발생
 
 ### subscribe() 함수

- RxJava는 내가 동작시키기 원하는 것을 사전에 정의해둔 다음 실제 그것이 실행되는 시점을 조절 가능 -> 이때 사용하는 것이 **subscribe()** 이다.
- Observable 은 just() 등의 팩토리 함수로 데이터 흐름을 정의한 후 subscribe() 함수를 호출해야 실제로 데이터를 발행함

```java
    public final Disposable subscribe() {
        return subscribe(Functions.emptyConsumer(), Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }
```

```java
    public final Disposable subscribe(Consumer<? super T> onNext) {
        return subscribe(onNext, Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }
```
 
    
```java
   public final Disposable subscribe(Consumer<? super T> onNext, Consumer<? super Throwable> onError) {
        return subscribe(onNext, onError, Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }
```
    
```java  
    public final Disposable subscribe(Consumer<? super T> onNext, Consumer<? super Throwable> onError,
            Action onComplete) {
        return subscribe(onNext, onError, onComplete, Functions.emptyConsumer());
    }
```

1. 인자가 없는 subscribe() 함수는 onNext와 onComplete 이벤트를 무시하고 onError 이벤트가 발생했을 때만 OnErrorNotImplementedException을 던진다. 따라서 Observable로 작성한 코드를 테스트하거나 디버깅할 때 활용
2. 인자가 1개 있는 오버로딩은 onNext 이벤트를 처리한다. 이때도 onError 이벤트가 발생하면 OnErrorNotImplementedException을 던진다.
3. 인자가 2개인 함수는 onNext와 onError 이벤트를 처리한다.
4. 인자가 3개인 함수는 onNext, onError, onComplete 이벤트를 모두 처리할 수 있다.

  - 위의 함수 원형은 모두 Disposable 인터페이스의 객체를 리턴한다.

```java
void dispose()
boolean isDisposed()
```

 - dispose()는 Observable에게 더 이상 데이터를 발행하지 않도록 구독을 해지하는 함수이다.
 - Observable이 onComplete 알림을 보냈을 때 자동으로 dispose()를 호출해 Observable과 구독자의 관계를 끊는다.
 - onComplete 이벤트가 정상적으로 발생했다면 구독자가 별도로 dispose()를 호출할 필요는 없다.

```java
    public void usingIsDisposed(){
        Observable<String> source = Observable.just("RED","GREEN","YELLOW","BLUE");

        Disposable disposable = source.subscribe(
                v -> System.out.println("onNext() : value :" + v),
                err -> System.err.println("onError() : err :" + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println("isDisposed() : "+ disposable.isDisposed());
```

### create() 함수
 - onNext, onComplete, onError 같은 알람을 개발자가 직접 호출해야 한다.

 
```java
 Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) ->{
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });
        source.subscribe(System.out::println);
```
 - subscribe() 을 호출하지 않으면 아무것도 출력되지 않는다.

### fromArray() 함수
 - 배열에 들어 있는 데이터를 처리할 때 사용

```java
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
```

### fromIterable() 함수

```java
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
    }
```

### fromCallable() 함수

 - 비동기 클래스나 인터페이스와의 연동
 - Callable 인터페이스
   - 비동기 실행 후 결과를 리턴하는 call() 메서드를 정의
   - Runnable 인터페이스와는 실행 결과를 리턴한다는 점에서 차이가 있다.
 
```java
//람다 표현식을 사용할 때
    public void usingCallable() {

        Callable<String> callable = () -> {
            Thread.sleep(2000);
            return "Hello callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }
```

```java
    //람다 표현식을 사용하지 않을때
    public void usingCallable2() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Hello callable2";
            }
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }
```

### fromFuture() 함수

 - 동시성 API 로 비동기 계산의 결과를 구할 때 사용
 - Executor 인터페이스를 구현한 클래스에 Callable 객체를 인자로 넣어 Future 객체를 반환함
 - get() 메서드를 호출하면 Callable 객체에서 구현한 계산 결과가 나올 때까지 블로킹 됨
 - Executors 클래스는 단일 스레드 실행자(SingleThreadExecutor)뿐 아니라 다양한 스레드풀(FixedThreadPool, CachedThreadPool)을 지원함
   - RxJava는 위와 같은 실행자를 사용하기보단 RxJava에서 제공하는 스케줄러를 활용하도록 권장함
 
```java
public void usingFuture(){

        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(1000);
            return "Hello Future";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(System.out::println);
    }
```

### Single Class

- 1
 	- Single.fromObservable 을 활용
 	- 기존 Observable에서 첫 번째 값을 발행하면 onSuccess 이벤트를 호출한 후 종료 

 
```java
//1.기존 Observable 에서 Single 객체로 변환하기
        Observable<String> source = Observable.just("Hello Single!");
        Single.fromObservable(source).subscribe(System.out::println);
```

 - 2
 	- just()를 통해 Observable에 single() 함수를. 호출한다.
 	- single() 함수는 default value 를 인자로 갖는다.
 	- Observable에서 값이 발행되지 않을 때도 인자로 넣은 기본값을 대신 발행함
  
 
```java
//2. single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello Single!")
                .single("default Item")
                .subscribe(System.out::println);
```

 - 3
 	- 여러 개의 데이터를 발행할 수 있는 Observable을 Single 객체로 변환
 	- first() 를 호출하면 Observable 이 Single객체로 변환
 	- 하나 이상의 데이터를 발행하더라도 첫 번째 데이터 발행 후 onSuccess 이벤트 발생
  
 
```java
//3. first() 함수를 호출해 Single 객체 생성하기
        String[] colors = {"Red","Blue","Gold"};
        Observable.fromArray(colors)
                .first("default value")
                .subscribe(System.out::println);
```

 - 4
 	- empty() 함수를 통해 Single 객체를 생성
 	- 첫 번째 데이터 발행 후 onSuccess 이벤트가 발생
  
```java
//4. empty Observable 에서 Single 객체 생성하기
        Observable.empty()
                .single("default value")
                .subscribe(System.out::println);
```

 - 5
 	- take() 함수를 통해 Single 객체를 생성
  
```java
//5. take() 함수에서 Single 객체 생성하기
        Observable.just(new Order("Order_1"),new Order("Order_2"))
                .take(1)
                .single(new Order("default order"))
                .subscribe(System.out::println);
```

 

 

 