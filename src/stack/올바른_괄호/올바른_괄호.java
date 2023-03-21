package stack.올바른_괄호;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        // {는 stack에 넣기, }는 스택에서 빼기, 만약 스택이 비어 있다면 오류
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '(') {
                stack.add('(');
            } else if (!stack.empty()) {
               stack.pop();
            } else {
                return false;
            }
        }
        if (!stack.empty())
            answer = false;
        return answer;
    }
    public static void main(String[] args) {
        올바른_괄호 올바른_괄호 = new 올바른_괄호();
        boolean solution = 올바른_괄호.solution("(())");
        System.out.println(solution);
    }

}
