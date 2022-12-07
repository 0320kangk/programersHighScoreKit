package heap;

import java.util.PriorityQueue;

public class 더_맵게 {


    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : scoville) {
            priorityQueue.add(i);
        }
        while ( priorityQueue.size() >1 && priorityQueue.peek() < K ) {

            Integer firstSmall = priorityQueue.poll();
            Integer secondSmall = priorityQueue.poll();
            priorityQueue.add(firstSmall + secondSmall * 2);
            answer++;

        }
        if (priorityQueue.peek() < K) {
            return -1;
        }


        return answer;
    }

    public static void main(String[] args) {
        더_맵게 더_맵게 = new 더_맵게();
        int solution = 더_맵게.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(solution);
    }



}
