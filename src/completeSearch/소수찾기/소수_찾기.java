package completeSearch.소수찾기;

import java.util.ArrayList;
import java.util.List;

public class 소수_찾기 {
    void dfsD(String numbers, int k, boolean[] isUsed, List<Integer> list) {
        //만족하는 조건 소수라면?
        double sqrt = Math.sqrt(k);
        boolean decimal = true;
        for (int i = 2; i <= sqrt; i++) {
            if ( k % i == 0) {
                decimal = false;
                break;
            }
        }
        if (decimal == true && k != 0 && k != 1){
            if(!list.contains(k)){
                list.add(k);
            }
        }
        for (int i = 0; i < numbers.length(); i++) {
            if ( !isUsed[i]) {
                isUsed[i] = true;
                dfsD(numbers, k * 10 + numbers.charAt(i) - '0', isUsed, list);
                isUsed[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        boolean[] isUsed = new boolean[numbers.length()];
        List<Integer> list = new ArrayList<>();
        dfsD(numbers, 0, isUsed, list);
        answer = list.size();
        return answer;
    }
    //첫 번째 풀이
    /*boolean[] isUsed = new boolean[10];
    int[] cardsArr;
    String cards = "";
    int cardsLength;
    int numbersLength;
    List<Integer> numList =  new ArrayList<>();

    void func(int k) {
        if ( k == cardsLength ) {
            int num = cardsArr[0];
            for (int i = 1; i < cardsArr.length; i++) {
                num = cardsArr[i] + num * 10;
            }
            if (!numList.contains(num)) {
                numList.add(num);
            }
            return;
        }

        for(int i = 0; i < numbersLength; i++) {
            char c = cards.charAt(i);
            int cardNum = c - 48;
            if (!isUsed[i]) {
                cardsArr[k] = cardNum;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }

    }

    public int solution(String numbers) {

        int answer = 0;
        cards = numbers;
        numbersLength = cards.length();
        cardsLength = numbersLength;
        for (int i = 0; i < numbersLength; i++) {
            cardsArr = new int[cardsLength];
            func(0);
            cardsLength--;
        }

        for (int i = 0; i < numList.size() ; i++) {
            boolean isPrime = true;
            Integer num = numList.get(i);
            int abs = Math.abs(num);
            System.out.println(num);
            for (int j = 2; j < abs; j++) {
                if ( num % j == 0 ) {
                    isPrime=false;
                    break;
                }
            }
            if ( num != 0 && num != 1 && isPrime ) {
                answer++;
            }
        }
        return answer;
    }*/

    public static void main(String[] args) {

        소수_찾기 소수_찾기 = new 소수_찾기();
        int solution = 소수_찾기.solution("011");
        System.out.println(solution);
    }

}
