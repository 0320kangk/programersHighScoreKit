package sort.K번째수;

import java.util.Arrays;

public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        for ( int i = 0; i < commands.length ;i++ ) {
            int[] sortArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(sortArray);
            answer[i] = sortArray[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {

        K번째수 k번째수 = new K번째수();
        int[] solution = k번째수.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println( Arrays.toString(solution));

    }
}
