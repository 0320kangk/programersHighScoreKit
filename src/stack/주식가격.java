package stack;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {
        //stack 활용 풀이
/*
        Stack<Integer> stack = new Stack<>();
        int length = prices.length;
        int[] answer = new int[length];
        stack.push(0);
        for (int i = 1; i < length - 1; i++) {
            if (!stack.isEmpty()) {
                if ( prices[stack.peek()] <= prices[i] ) {
                    stack.push(i);
                } else {
                    period(stack, answer, i);
                    while (true) {
                        if ( !stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                            Integer index = stack.pop();
                            answer[index] = i - index;
                        } else {
                            break;
                        }
                    }
                    stack.push(i);
                }
            }

        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            answer[index] = length -1 - index;
        }*/
        int length = prices.length;
        int[] answer = new int[length];
        for (int i = 0; i < length ; i++) {
            for (int j = i + 1; j < length; j++) {
                if ( prices[i] <= prices[j] ) {
                    answer[i]++;
                }
            }
        }


        return answer;

    }

    private void period(Stack<Integer> stack, int[] answer, int i) {
        Integer index = stack.pop();
        answer[index] = i - index;
    }

    public static void main(String[] args) {
        주식가격 주식가격 = new 주식가격();
        int[] solution = 주식가격.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(solution));
    }


}
