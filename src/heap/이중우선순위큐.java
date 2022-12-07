package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());


        int num = 0;
        for (String operation : operations) {

            //값 입력
            if (operation.charAt(0) == 'I') {
                num = Integer.valueOf(operation.substring(2));
                priorityQueue.add(num);
                reversePriorityQueue.add(num);

            } else {
                //최솟값 구하기
                if ( operation.charAt(2) == '-') {
                    reversePriorityQueue.remove(priorityQueue.poll());
                }
                //최댓값 구하기
                else {
                    priorityQueue.remove(reversePriorityQueue.poll());
                }
            }

        }

        int[] answer = new int[2];
        if ( !priorityQueue.isEmpty() ) {
            answer[1] = priorityQueue.poll();
            answer[0] = reversePriorityQueue.poll();
        }

        return answer;
        /*
        두개의 큐를 만들고
        양쪽에 숫자를 다 넣는다.
        최솟값을 뽑는 경우 PQ에서 값을 뽑고,RPQ값 제거
        최댓값을 뽑는 경우 RPQ에서 값을 뽑고 PQ에서 값을 제거
        마지막에 양 큐의 가장 위의값 출력
         */

    }
    public static void main(String[] args) {

        이중우선순위큐 이중우선순위큐 = new 이중우선순위큐();
        int[] solution = 이중우선순위큐.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(Arrays.toString(solution));

    }
}
