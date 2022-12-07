package stack;

import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어 {
        public int[] solution(int []arr) {

            Stack<Integer> stack = new Stack<>();
            stack.push(arr[0]);
            for (int num : arr) {
                if (stack.peek() != num) {
                    stack.push(num);
                }
            }
            return stack.stream()
                    .mapToInt(num -> num)
                    .toArray();
        }

    public static void main(String[] args) {

        같은_숫자는_싫어 같은_숫자는_싫어 = new 같은_숫자는_싫어();
        int[] solution = 같은_숫자는_싫어.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(Arrays.toString(solution));


    }

}
