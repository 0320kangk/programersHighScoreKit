package stack;

import java.util.Stack;

public class 올바른_괄호 {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        char braket;
        for( int i = 0 ;  i < s.length(); i++) {
            braket = s.charAt(i);
            if ( braket == ')' ) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            } else {
                stack.push(braket);
            }
        }


        if ( !stack.isEmpty() ) {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {

        올바른_괄호 올바른_괄호 = new 올바른_괄호();
        boolean solution = 올바른_괄호.solution("(()(");
        System.out.println(solution);

    }

}
