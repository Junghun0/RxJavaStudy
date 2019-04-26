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
 

 

 
