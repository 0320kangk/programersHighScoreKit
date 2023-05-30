# K번째수 풀이

---

### [문제링크](https://school.programmers.co.kr/learn/courses/30/lessons/42748)

### 문제풀이
이 문제는 2차원 정수 배열 commands 값에 맞게 array 배열을 가공하여 답을 구하면 되는 문제이다.
[i, j, k]를 원소로 가진 2차원 배열 commands의 값 i, j를 이용하여 array의 배열의 i부터 j 번째까지의 값을 잘라
새로운 배열을 만들고 오름차순으로 정렬하여 k 번째 수를 찾아 답을 구한다.
### 소스 코드
```java
package sort.K번째수;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length]; //답을 담을 answer 배열 정의
        for ( int i = 0; i < commands.length ;i++ ) {
            int[] sortArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //조건에 맞는 배열 만들기
            Arrays.sort(sortArray);// 배열 정렬
            answer[i] = sortArray[commands[i][2]-1]; // k번째 값을 answer 배열에 넣기
        }
        return answer;
    }

    public static void main(String[] args) {

        K번째수 k번째수 = new K번째수();
        int[] solution = k번째수.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println( Arrays.toString(solution));

    }
}
```