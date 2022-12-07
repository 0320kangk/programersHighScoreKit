package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 폰켓몬 {

    public int solution(int[] nums) {

        int answer = 0;
        Map<Integer, Integer> poketmonMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap((p) -> p,
                        (p) -> 1, (oldValue, newValue) -> {
                            return newValue += oldValue;
                        }
                ));
        int keys = poketmonMap.size();
        if (nums.length/2 >= keys ) {
            return keys;
        } else {
            return nums.length/2;
        }


//
//        int answer = 0;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        answer = map.size();
//        if (answer > nums.length / 2 ) {
//
//            answer = nums.length / 2;
//
//        }
//
//        return answer;
    }

    public static void main(String args[]) {

        폰켓몬 폰켓몬 = new 폰켓몬();
        int solution = 폰켓몬.solution(new int[]{3, 1, 2, 3});
        System.out.println(solution);


    }

}
