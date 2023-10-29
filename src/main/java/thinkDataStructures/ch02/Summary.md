## 02. 알고리즘 분석
위에서 ArrayList, LinkedList를 예시로 살펴봤다. 이 둘은 각자 사용하기 적합한 상황이 있다. 어떤 상황에서 어떤 것을 사용하면
좋을지 알 수 있는 방법은 둘 다 시도해 보고 각각 얼마나 걸리는지 알아보는 것이다. 이러한 접근 방법을 프로파일링이라고 한다.

이러한 방식은 직접 구현해야하고 상황에 따라 결과가 달라질 수 있다는 문제가 존재하는데 알고리즘 분석을 사용해서 이러한 문제점을 해결할 수 있다.
하지만 몇 가지 가정을 해야한다.

1. 세부적인 사항을 다루지 않기 위해서 기본 연산을 식별한다. 그리고 각 알고리즘에 필요한 연산의 수를 센다.
2. 입력 데이터의 세부 사항을 다루지 않으려면 입력 데이터에 대한 평균 성능을 분석하면 된다. 
3. 알고리즘이 각 문제에 따라 좋고 나쁨이 결정될 수 있음을 가정해야 한다.

대부분의 간단한 알고리즘은 아래 몇 가지 범주로 나눈다.

### 상수 시간
실행 시간이 입력 크기에 의존하지 않으면 알고리즘은 상수 시간을 따른다고 한다. 
> n개의 배열에서 []으로 요소에 접근할 때 동작 수는 배열의 크기와는 관계없다.


### 선형
실행 시간이 입력 크기에 비례하면 선형이라고 한다. 
> n개 배열의 모든 요소의 합을 구하는 연산은 n번 접근해서 n-1 번 합연산을 해야한다. 총 횟수는 2n - 1이고 n에 비례한다.

### 이차
실행 시간이 n<sup>2</sup>에 비례하면 이차`(quadratic)`이라고 한다.
> 리스트에 있는 어떤 요소가 두 번 이상 나타나는지 알고 싶을때, 간단한 알고리즘은 각 요소를 다른 모든 요소와 비교하는 것이다. 
> n개의 요소가 있고 각 n - 1개의 다른 요소와 비교하면 총 비교 횟수는 n<sup>2</sup> - n이 된다.


## [2.1 선택 정렬](../practice/SelectSort.java)

* 최소 값을 탐색한다.
* 이미 정렬한 최소 값을 제외한 인덱스의 맨 앞으로 이동시킨다.


1. 요소를 읽고 쓰는 것은 `상수 시간` 연산이다.
    - 첫 번째 위치를 알고 있다면 한 번의 곱/합 연산으로 어떤 요소에도 접근할 수 있다.
    

2. 가장 작은 값은 찾는 연산도 두 요소에 접근, 한 번의 비교 연산을 반복하는 연산으로 이뤄져 있다.
    - start 인자가 0이면 모든 배열을 검색하고 전체 비교 횟수는 배열의 길이인 n번이다. (상수 시간 연산)
    - start가 1이면 n - 1이 된다.
    - 일반적으로 비교 횟수는 n - (start) 가 된다. 
    - 따라서 실행 시간이 크기에 영향을 받는 `선형`이 된다.
    

3. 매번 가장 작은 값을 찾는 연산을 호출하고 바꾸는 연산을 한다.
    - 정렬은 0에서 n - 1까지 반복하므로 n 번 반복한다.
    - 한 번 정렬한 이후는 1에서 n - 1로 n -1 번 반복한다.
    - 총 비교 횟수는 n + n-1 + ... + 0이다.
    - 이 수열의 합은 n ( n + 1 ) / 2이고 n<sup>2</sup>에 비례한다.
    - `이차`이다.

 
## 2.1 BigO<sup>[[1]](#bigO)</sup> 표기법
모든 상수 시간 알고리즘은 O(1)이라는 집합에 속한다. 따라서 알고리즘이 상수 시간임을 다르게 표현하는 방법이 O(1)이다. 마찬가지로 선형
알고리즘은 O(n)에 속하며 모든 이차 알고리즘은 O(n<sup>2</sup>)에 속한다.

이렇게 알고리즘을 분류하는 방법을 `BigO` 표기법이라고 한다. 이 표기법은 알고리즘을 작성할 때 알고리즘이 어떻게 동작하는지에 관한 일반적인 법칙을 표현하는 방법을 제공한다.

예를 들어 상수 시간 알고리즘 `f`에 이어 선형 시간 알고리즘 `g`를 수행하면 총 실행 시간은 선형이된다.

>f ∈ O(1), g ∈ O(n) -> f + g ∈ O(n)

추가로 두 개의 선형 연산을 수행하면 합은 선형이다.

>f ∈ O(n), g ∈ O(n) -> f + g ∈ O(n)

k가 상수인 한 선형 연산을 k번 수행하면 합은 선형이다.

>f ∈ O(n), kf ∈ O(n)

하지만 선형 연산을 `n`번 반복하면 결과는 이차가 된다.

>f ∈ O(n), nf ∈ O(n<sup>2</sup>)

증가차수`order of growth`는 같은 개념의 다른 이름이다.  


--------------------------------------------------------------------------
<a name="bigO">1</a> : 빅 O 표기법은 주장이 특정 값이나 무한대로 향하는 경향이 있을 때 함수의 제한 동작을 설명하는 수학적 표기법이다. 컴퓨터 과학에서, 빅 O 표기법은 입력 크기가 증가함에 따라 실행 시간이나 공간 요구 사항이 어떻게 증가하는지에 따라 알고리즘을 분류하는 데 사용됩니다.
