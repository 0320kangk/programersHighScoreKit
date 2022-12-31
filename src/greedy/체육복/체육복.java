package greedy.체육복;

import java.util.Arrays;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int count = lost.length;
        for (int i = 0; i < lost.length ; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ( lost[i] == reserve[j] ) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count--;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ( lost[i] == reserve[j] + 1 || lost[i] == reserve[j] -1 ) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count--;
                    break;
                }
            }
        }

        int answer = n - count;
        return answer;

    }

    public static void main(String[] args) {
        체육복 체육복 = new 체육복();
        int solution = 체육복.solution(5, new int[]{2, 4}, new int[]{3});
        System.out.println(solution);
    }
}
