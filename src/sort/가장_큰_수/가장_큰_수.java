package sort.가장_큰_수;

import java.util.Arrays;
import java.util.Stack;


public class 가장_큰_수 {

    public String solution(int[] numbers) {
        String[] numberArray = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberArray[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numberArray, (((o1, o2) -> (o2+o1).compareTo(o1+o2))));
        if(numberArray[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : numberArray) {
            sb.append(s);
        }
        return sb.toString();
/*
        String[] numberArray = new String[numbers.length];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberArray, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));

        if(numberArray[0].equals("0")) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : numberArray) {
            stringBuilder.append(s);
        }
        String answer = stringBuilder.toString();

        return answer;*/
    }

    public static void main(String[] args) {
        가장_큰_수 가장_큰_수 = new 가장_큰_수();//874
        String solution = 가장_큰_수.solution(new int[]{1,2,3});
        System.out.println(solution);

    }
}
