package dynamicProgramming.정수_삼각형;

import java.util.ArrayList;
import java.util.List;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = triangle.length;
        for (int i = 0; i < length; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(triangle[0][0]);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int a = 0;
                int b = 0;
                if ( j - 1 >= 0 ) {
                    a = lists.get(i-1).get(j-1) + triangle[i][j];
                }
                if ( j < lists.get(i-1).size() ) {
                    b = lists.get(i-1).get(j) + triangle[i][j];
                }
                lists.get(i).add(Math.max(a, b));
            }

        }
        int answer = lists.get(length - 1)
                .stream()
                .mapToInt(num -> num)
                .max()
                .orElse(0);

        return answer;
    }

    public static void main(String[] args) {
        정수_삼각형 정수_삼각형 = new 정수_삼각형();
        int solution = 정수_삼각형.solution(new int[][]{{7}, {3, 8},{8,1,0}, {2,7,4,4}});
        System.out.println(solution);
    }
}
