package binary_search;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0; //최소 시간
        long right = (long) n * times[times.length - 1]; //최대 시간
        while( left <= right) {
            long mid = (left + right) / 2;
            long person = 0;
            for (int i = 0; i < times.length; i++) {
                person += mid / times[i] ;
            }
            //시간이 더 필요한 경우
            if ( person < n) {
                left = mid + 1;
            }
            // 시간이 넘치는 경우 or 시간이 맞는 경우
            else if ( person >= n){
                right = mid - 1;
                answer = mid;
            }
            System.out.println(right);
        }
        return answer;
    }

    public static void main(String[] args) {
        입국심사 입국심사 = new 입국심사();
        long solution = 입국심사.solution(6, new int[]{7, 10});
        System.out.println(solution);
    }
}
