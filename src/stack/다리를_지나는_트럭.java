package stack;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<truck> weightsQueue = new LinkedList<>();
        Queue<truck> bridgeLengthQueue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            truck truck = new truck(truck_weight);
            weightsQueue.add(truck);
        }

        int answer = 0;
        int total_weight = 0;

        while( !bridgeLengthQueue.isEmpty() || !weightsQueue.isEmpty() ){

            for (truck truck : bridgeLengthQueue) {
                truck.location++;
            }

            if ( bridgeLengthQueue.size() < bridge_length &&
                    !weightsQueue.isEmpty() &&
                    weight >= total_weight + weightsQueue.peek().weight) {
                truck poll = weightsQueue.poll();
                total_weight += poll.weight;
                bridgeLengthQueue.add(poll);

            }

            if ( !bridgeLengthQueue.isEmpty()  &&
                    bridgeLengthQueue.peek().location >= bridge_length
            ) {

                truck poll = bridgeLengthQueue.poll();
                total_weight -= poll.weight;

            }

            answer++;

        }

        /**
         * 1. 트럭을 보낸다
         * 2. 다리 길이와 견딜 수 잇는 무게를 고려한다.
         * 3. 최소 다리의 길이만큼 시간이 지나야 다리를 건넌것이다.
         */

        return answer+1;
    }

    class truck {
        int weight;
        int location ;

        public truck(int weight) {
            this.weight = weight;
            this.location = 1;
        }
    }


    public static void main(String[] args) {
        다리를_지나는_트럭 다리를_지나는_트럭 = new 다리를_지나는_트럭();
        int solution = 다리를_지나는_트럭.solution(2, 10, new int[]{7,4,5,6});
        System.out.println(solution);
    }

}
