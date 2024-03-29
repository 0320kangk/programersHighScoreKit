package stack.프린터;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue= new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int index = priorities.length -1;
        //순서데로 뺴서 몇번째인지 알아내기
        while ( true ) {
            Pair poll = queue.poll();
            if (poll.value == priorities[index] ){
               if (poll.index == location)
                   break;
               index--;
               answer++;
               continue;
            }
            queue.add(poll);
        }
        return ++answer;


        /*
        우선순위 큐 풀이
        PriorityQueue<Object> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.add(priorities[i]);
        }

        while ( !priorityQueue.isEmpty() ) {
            for (int i = 0; i < priorities.length; i++) {

                if (priorities[i] == (int) priorityQueue.peek() ) {
                    if ( i == location) {
                        answer++;
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }*/

/*        LinkedList<Pair> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }

        while (!queue.isEmpty()) {

            int current = queue.peek().value;
            boolean flag = false;

            for (Pair pair : queue) {
                if ( pair.value > current) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                Pair temp = queue.poll();
                queue.add(temp);
            } else {
                answer++;
                Pair pair = queue.poll();

                if (pair.index == location) {
                    return answer;
                }
            }

        }
        return answer;*/

    }

    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

    }




    public static void main(String[] args) {
        프린터 프린터 = new 프린터();
        int solution = 프린터.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(solution);
    }

}
