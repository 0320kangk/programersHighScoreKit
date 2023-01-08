package greedy.큰_수_만들기;

import java.util.*;

public class 큰_수_만들기 {

    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int length = number.length();
        int digit = length - k;

        for (int i = 0; i < length; i++) {
            int size = stack.size();
            char c = number.charAt(i);
            for (int j = 0; j < size; j++) {
                if ( !stack.isEmpty() &&
                        stack.peek() < c &&
                        stack.size() + (length - i)  > digit ) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if ( stack.size() < digit) {
                stack.add(c);
            }
        }
        Iterator<Character> iterator = stack.stream().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        answer=sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        큰_수_만들기 큰_수_만들기 = new 큰_수_만들기();
        String solution = 큰_수_만들기.solution("1924", 2);
        System.out.println(solution);
    }
}
