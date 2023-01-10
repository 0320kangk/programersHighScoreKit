package greedy.단속카메라;

import java.util.Arrays;
import java.util.Comparator;

public class 단손카메라 {

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparing(route -> route[1]));

        int exitSection = -30001;
        for (int i = 0; i < routes.length; i++) {
            if ( routes[i][0] > exitSection ) {
                answer++;
                exitSection = routes[i][1];
            }
        }
        return answer;
    }

}
