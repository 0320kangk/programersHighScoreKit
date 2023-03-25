package stack.주식가격;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Stack<Integer[]> stack = new Stack<>();// 인덱스와 값을 넣을 stack

        for (int i = 0; i < length; i++) {
            answer[i] = length - i - 1; //값을 최대 값으로 세팅
            Integer[] price = {i, prices[i]};//stack에 넣을 값, 인덱스 와 가격

            while ( !stack.empty() && stack.peek()[1] > price[1] ) {
                //감소
                Integer[] popPrice = stack.pop();
                answer[popPrice[0]] = i - popPrice[0];
            }
            stack.push(price);
        }
        return answer;

     //다른 풀이
     /* int length = prices.length;
        int[] answer = new int[length];
        for (int i = 0; i < length ; i++) {
            for (int j = i + 1; j < length; j++) {
                answer[i]++;
                if ( prices[i] > prices[j] ) {
                    break;
                }
            }
        }*/
    }
    public static void main(String[] args) {
        주식가격 주식가격 = new 주식가격();
        int[] solution = 주식가격.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(solution));
    }


}
