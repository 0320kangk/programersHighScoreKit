package dynamicProgramming.N으로_표현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로_표현 {
    void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b) {

        for (Integer num1 : a) {
            for (Integer num2 : b) {
                union.add(num1 + num2);
                union.add(num1 * num2);
                union.add(num1 - num2);
                if ( num2 != 0) {
                    union.add(num1/num2);
                }
            }
        }
    }
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            setList.add(new HashSet<Integer>());
        }
        if (number == N)
            return 1;
        setList.get(1).add(N);
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i / 2; j++) {
                unionSet(setList.get(i), setList.get(j), setList.get(i-j));
                unionSet(setList.get(i), setList.get(i-j), setList.get(j));
            }
            String stringN = Integer.toString(N);
            setList.get(i).add(Integer.valueOf(stringN.repeat(i)));
            for (Integer num : setList.get(i)) {
                if (num == number) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        N으로_표현 n으로_표현 = new N으로_표현();
        n으로_표현.solution(5,12);
    }
}
