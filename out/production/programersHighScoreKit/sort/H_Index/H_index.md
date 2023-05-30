# H-Index
### [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42747)

### 문제 풀이
이 문제는 최댓값 h를 구하는 문제이다.
h는 논문 h번 이상 인용 && h번 논문 개수 이상 && 나머지 논문 h 이하 인용이어야 한다.
예를 들어 h가 3이면 3번 이상의 인용된 논문이 3개 이상 있어야 하며 나머지 논문은 3번 이하 인용되어야 한다.
최댓값 h를 구하기 위해서는 h의 값을 논문 최대 개수로 정의하여 h를 가능한 가장 큰 값으로 정의하여 조건을 만족하는지 확인한다.
조건을 만족하지 못한다면 h의 크기를 1씩 줄여가며 최댓값을 찾는다.


### 소스 코드

```java
class Solution {
    public int solution(int[] citations) {
        int h = citations.length; // 논문 개수
        int count = 0; // 조건을 만족하는 논문 개수
        boolean result = false;
        //논문 h번 이상 인용 h번 논문 개수 이상 만족, 나머지 논문 h 이하 인용
        while ( true ) {
            count=0;//논문 개수 초기화
            for (int citation : citations) {
                //논문의 인용수가 h를 넘는지 확인하기
                if (citation >= h) {
                    count++;//논문 개수 더하기
                }
            }
            //인용수와 논문 개수가 h보다 크다면 답을 찾은 것 이므로 h 반환
            if (count >= h) {
                return h;
            }
            h--;
        }
    }
}

```