package greedy.구명보트;

import java.util.Arrays;

public class 구명보트2 {
    public int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);

        int min = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if ( people[max] + people[min] <= limit)
                min++;
            answer++;
        }
        return answer;

    }

}
