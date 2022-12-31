package hash.위장;

import java.util.*;
import java.util.stream.Collectors;

public class 위장 {
    public int solution(String[][] clothes) {

        Map<String, Integer> clothesMap = Arrays.stream(clothes)
                .collect(Collectors.toMap(
                        clothe -> clothe[1],
                        clothe -> 1,
                        (oldValue, newValue) -> {
                            return newValue += oldValue;
                        }));
        Collection<Integer> values = clothesMap.values();
        int answer = 1;

        for (Integer value : values) {
            answer *= value + 1;
        }
        answer -= 1;
        return answer;
    }
    public static void main(String[] args) {

        위장 위장 = new 위장();
        int solution = 위장.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "face"}});
//        int combination = 위장.combination(1, 2); 1c2 = 0
        System.out.println(solution);
    }
}
