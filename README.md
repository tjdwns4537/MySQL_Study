# 데이터베이스 공부

### 실습 주제
: 고객을 적고, 해당 고객이 어떤 작업 내역을 가지고 있는지 확인할 수 있는 기능 구현

### 실습 목표
- 쿼리를 직접 작성하며, 성능 개선에 대해 좀 더 알아보자.



#### [Table]
- CUSTOMER
- WORKS

#### [Feature]
- JPA + MySQL 활용
- native query 활용


# 2023.02.25

<details>

[개념 및 특이사항]
1. DML = 데이터 조작어
   : 테이블 조회/변형
- INSERT : Import csv 활용
- SELECT : * 를 최대한 사용하지 않아 성능을 개선시키는 방법으로 쿼리 구성

2. TCL = 트랜잭션 제어어
   : 논리적인 작업의 단위를 묶어서 DML에 의해 조작된 결과를 작업단위(트랜잭션) 별로 제어하는 명령어를 말함.
- ROLLBACK, COMMIT 을 활용해 트랜잭션 단위를 이해해보자

<br>

[관계]

1. 고객의 이름으로 어떤 작업을 가지고 있는지 확인 가능해야됨
2. 작업 번호를 바탕으로 해당 작업이 어떤 고객을 통해 이뤄졌는지 확인 가능해야됨

<br>

[OneToMany]
- 고객 : 작업이 없거나 1개 이상을 소지할 수 있으므로, 1:N관계
- targetEntity
- cascade
- fetch
- mappedBy
- orphanRemoval

<br>

[ManyToOne]
- 작업내역 : 많은 작업 내역들이 하나의 고객에게 매핑되므로, N:1관계

<br>

[Cascade]
- All : 상위 엔티티에서 하위 엔티티로 모든 작업 전파
- Persist
- Merge
- Remove
- Refresh
- Detach

<br>

[프록시]
- 객체가 데이터베이스에 저장되어 있으면, 연관된 객체를 마음껏 탐색하기 어렵다.
- JPA 구현체들은 이 문제를 해결하기위해 프록시를 사용한다.
- 프록시는 연관된 객체를 처음부터 데이터베이스에서 조회하는 것이 아니라, 실제 사용하는 시점에 데이터베이스에서 조회한다.
- 하지만, 자주 함께 사용하는 객체들은 조인을 사용해 함께 조회하는것이 효과적이다.

<br>

[프록시 클래스와 객체]
- 프록시 클래스는 실제 클래스를 상속받아 만들어져 실제 클래스의 겉모양과 같다.
- 프록시 객체는 실제 객체에 대한 참조(target)을 보관한다.
- 그럼 프록시 객체는 메소드를 호출하면 실제 객체의 메소드를 호출한다. ( 실제 DB조회 )

<br>

[현재 나는 어떻게 객체를 호출할 것인가?]
- 고객 정보를 가져올 때, 작업 내역을 함께 조회하는것이 비효율적이다.
- 지연로딩이 필요하다.
- worklist.getWorkList() 와 같이 작업 내역을 직접 호출 할때 DB에서 필요한 데이터를 조회하는 것이 좋다.
- 그렇다면 실제 엔티티 객체 대신 DB에 조회를 지연할 수 있는 가짜객체가 필요한대, 이게 프록시 객체이다.

<br>

[Fetch: lazy, Eager]
- ManyToOne 어노테이션에 fetchType을 줄 수 있다.
- Eager: 즉시 함께 조회
- Lazy : 연관 엔티티를 프록시로 조회한다. 그리고 실제 사용할 때는 초기화되어 DB를 조회한다.

<br>

[JoinColumn : outerJoin, InnerJoin]
- JoinColumn (nullable = true) : Null 허용, 아우터조인
- JoinColumn (nullable = false) : Null 허용하지 않음, 이너조인

<br>

[EnumType을 DB에 그대로 반영하는 방법]
- 해당하는 객체에 @Enumerated(EnumType.String) 을 달아준다. (성능상 좋지않음)
- Attribute Converter 사용 : https://lng1982.tistory.com/279 (리팩토링 방향-아직 프로젝트 규모가 작음)

#### TODO
- CustomerService, WorkService 쿼리 작성
- Lazy로딩 성능 테스트

</details>

