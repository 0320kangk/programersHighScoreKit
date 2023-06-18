package greedy.구명보트;

import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        구명보트 구명보트 = new 구명보트();
        int solution = 구명보트.solution(new int[]{70,80,50}, 100);
        System.out.println(solution);
    }
}
