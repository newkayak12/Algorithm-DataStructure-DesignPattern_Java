import org.junit.jupiter.api.Test;

public class Chapter_03_Search {
    /**
     *  1.  배열 검색
     *
     *  1-1. 선형 검색 : 무작위로 늘어놓은 데이터 모임에서 검색을 수행한다.
     *  1-2. 이진 검색 : 일정한 규칙으로 늘어놓은 데이터 모임에서 아주 빠른 검색을 수행한다.
     *  1-3. 해시법 : 추가, 삭제가 자주 일어나는 데이터 모임에서 아주 빠른 검색을 수행한다.
     *    1-3-1. 체인점 : 같은 해시 값의 데이터를 선형 리스트로 연결하는 방법
     *    1-3-2. 오픈 주소법 : 데이터를 위한 해시 값이 충돌할 때 재해시하는 방법
     *
     *
     *  데이터 집합이 있을 때 검색에 사용할 알고리즘은 계산 시간이 짧은 것을 선택하면 된다. 그러나 데이터 집합에 대한 검색뿐 아니라 데이터의 추가,
     *  삭제 등을 자주하는 경우라면 검색 이외의 작업에 소요되는 비용을 종합적으로 평가하여 알고리즘을 선택해야 한다.
     *  예를 들어 데이터 추가를 자주 하는 경우에는 검색이 빠르더라도 데이터의 추가 비용이 많이 들어가는 알고리즘은 피하는 것이 좋다.
     *
     *
     *
     *
     *      1-1. 선형 검색
     *
     * 요소가 직선 모양으로 늘어선 배열에서의 검색은 원하는 키 값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 요소로를 검색하면 되는데, 이를 선형 검색(linear search)
     * 또는 순차 검색(sequential search) 이라는 알고리즘이다.
     *
     * 이 경우의 탐색은 조건을 두 가지 갖다.
     *
     *      조건 1) 검색할 값을 발견하지 못하고 배열의 끝을 지나간 경우
     *      조건 2) 검색할 값과 같은 요소를 발견한 경우
     *
     */

    @Test
    void seqSearch(){
        int key = 55;
        int i = 0;
        int[] target = {22,8,55,32,120,55,70};
        int idx = 0;


//        while (true) {
//            if( i >= target.length - 1 ) {
//                idx = -1;
//                break;
//            }
//            if(target[i] == key) {
//                idx = i;
//                break;
//            }
//            i++;
//        }
        for ( ; i < target.length; i++){
            if(target[i] == key){
                break;
            } else if (target[i] != key && i == target.length -1){
                i = -1;
                break;
            }
        }

        idx = i;

        System.out.println(idx);
    }
    /**
     * SeqSearch는 배열의 처음부터 끝까지 순회하며 지정된 key와 같은 요소를 검색하면 인덱스를 반환한다. 만약 key와 같은 요소가 여러 개라면
     * 처음으로 발견한 이후 종료된다.
     *
     *
     *      1-2. 보초법
     *
     * 선형 검색은 반복할 때마다 종료조건 - 1) 검색할 값을 발생하지 못하고 배열의 끝을 지나간 경우, 2) 검색할 값과 같은 요소를 발견할 경우-을 체크한다.
     * 이 비용은 무시하기 어렵다. 이 비용을 반으로 줄이는 보초법(sentinel method)이다.
     *
     * 보초법은 검색하기 전에 검색하고자 하는 키 값을 맨 끝 요소에 저장한다. 이때 저장하는 값을 보초라고 한다.
     *
     *      > a를 검색하기 위해 배열의 맨 끝에 a를 저장한다.
     *      > b를 검색하기 위해 배열의 맨 끝에 b를 저장한다.
     * 그러면 원하는 값이 원래 데이터에 존재하지 않아도 보초를 검색하면 종료 조건 2)가 성립한다. 이렇게하면 1)번의 종료 조건을 고려할 필요가 없어진다.
     * 보초는 반복문에서 종료 판단 횟수를 2회에서 1회로 줄인다.
     */

    @Test
    void searchSen(){
        int[] target = {22, 8, 55, 32, 120, 55, 70, 0};
        int key = 120;
        target[target.length - 1] = key;

        int i = 0;
        while (true) {
            if(target[i] == key) break;

            i++;
        }

        System.out.println(i == target.length - 1 ? -1 : i);
    }

    /**
     * [1] 배열의 맨 끝에 보초를 대입
     * [2] 배열을 순서대로 검사
     * [3] 조건이 완료되면 찾은 인덱스가 맨 끝인지 아닌지 판별
     *
     *
     *      1-3. 이진 검색
     *
     * 이 알고리즘을 적용하는 전제 조건은 데이터가 키 값으로 이미 정렬되어있다는 것을 전제로 한다. 이진 검색은 선형 검색보다 조금 더 빠르게 검색할 수 있다는
     * 장점이 있다.
     *
     *
     *      > 이진 검색
     * 이진 검색(binarySearch)은 요소가 오름차순 또는 내림차순으로 정렬된 배열에서 검색하는 알고리즘이다.
     *
     * 예시) [5, 7, 15, 28, 29, 31, 39, 58, 68, 70, 95]
     *
     *  만약 39를 찾으려한다고 한다. 중간 값 31을 기준으로 왼쪽으로는 모두 배제해도 된다. 그 다음 남은 영역 중 중간 값 68을 잡는다.
     *  이번에는 오른쪽을 배제하면 된다.
     *
     *  이러한 방법은 업/다운 게임과 굉장히 유사하다. 이제 수식으로 생각해보자
     *
     *  인덱스의 시작을 pl, 맨 끝을 pr 중앙을 pc로 지정하자. 검색을 시작할 때는 pl은 0, pr은 n - 1, pc (n-1)/2으로 초기화한다.
     *  결과적으로 pc 인덱스의 값과 찾고자하는 값이 같으면 성공이다.
     *
     *      case 1. a[pc] < key
     *          a[pl] ~ a[pc]는 제외하면 된다. 검색 범위는 a[pc] 이후인 a[pc + 1] ~ a[pr]로 좁히면된다.
     *          그런 다음 pl을 pc + 1로 업데이트 한다.
     *
     *      case 2. a[pc] > key
     *          a[pc] ~ a[pr]은 key보다 크므로 제외한다. 이 경우 a[pr]을 a[pc - 1]로 업데이트 한다.
     *
     */


    @Test
    void binarySearch(){
        int[] array = {15, 27, 39, 77, 92, 108, 121};
        int key = 39;
        int pl = 0;
        int pr = array.length - 1;
        int result = 0;

        do {
            int pc = (pl + pr) / 2;
            if( array[pc] == key ) {
                result = pc;
                break;
            } else if( array[pc] < key ){
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while(pl <= pr);

        System.out.println(result);
    }
}
