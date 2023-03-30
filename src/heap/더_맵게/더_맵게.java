package heap.더_맵게;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while ( pq.size() > 1 && pq.peek() < K) {
            Integer food1 = pq.poll();
            Integer food2 = pq.poll();
            pq.add(food1 + food2 * 2);
            answer++;
        }

        if (pq.peek() < K) {
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
