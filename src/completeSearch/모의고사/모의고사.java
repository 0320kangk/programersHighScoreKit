package completeSearch;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] scoreArray = new int[3];
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int aLength = a.length;
        int bLength = b.length;
        int cLength = c.length;

        for (int i = 0; i < answers.length; i++) {
            if ( a[i % aLength] == answers[i]   ) {
                scoreArray[0]++;
            }

            if ( b[i % bLength] == answers[i] ) {
                scoreArray[1]++;
            }

            if ( c[i % cLength] == answers[i] ) {
                scoreArray[2]++;
            }
        }

        //처음 풀이
     /*   for (int i = 0; i < answers.length; i++) {
            if ( i % 5 + 1 == answers[i] ) {
                answerArray[0]++;
            }

            if ( (i % 2 == 0 && answers[i] == 2) ||
                    (i % 8 == 1  && answers[i] == 1) ||
                    (i % 8 == 3  && answers[i] == 3) ||
                    (i % 8 == 5  && answers[i] == 4) ||
                    (i % 8 == 7  && answers[i] == 5)) {
                answerArray[1]++;
            }

            if ( ((i % 10 == 0|| i % 10 == 1) && answers[i] == 3) ||
                    ((i % 10 == 2 || i % 10 == 3) && answers[i] == 1) ||
                    ((i % 10 == 4 || i % 10 == 5) && answers[i] == 2) ||
                    ((i % 10 == 6 || i % 10 == 7) && answers[i] == 4) ||
                    ((i % 10 == 8 || i % 10 == 9) && answers[i] == 5)  ) {
                answerArray[2]++;
            }
        }*/
        int max = Arrays.stream(scoreArray).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < scoreArray.length; i++) {
            if (max == scoreArray[i]) {
                list.add(i+1);
            }
        }
        int[] answer = list.stream()
                .mapToInt( x -> x)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        모의고사 모의고사 = new 모의고사();
        int[] solution = 모의고사.solution(new int[]{1,3,2,4,2});
        System.out.println(Arrays.toString(solution) );
    }

}
