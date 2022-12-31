package completeSearch;

public class 전력망을_둘로_나누기 {

    int result = 100;
    int count;
    int length;
    //n초기값은 1 (송전탑)
    void tracking(int n, wire[] wires ) {
        // 먼가 복잡하면 기능을 분할해서 생각하자.
        // 일단 연결된 송전탑을 찾자
            for (int i = 0; i < length; i++) {
                if (wires[i].used == false &&
                        (wires[i].location[0] == n ||
                                wires[i].location[1] == n)) {
                    wires[i].used = true;
                    count++;
                    if ( wires[i].location[0] == n) {
                        tracking(wires[i].location[1], wires);
                    } else if ( wires[i].location[1] == n ) {
                        tracking(wires[i].location[0], wires);
                    }
                    wires[i].used = false;
                }

            }
    }

    class wire {
        int[] location;
        boolean used;

        public wire(int[] location, boolean used) {
            this.location = location;
            this.used = used;
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = -1;

        length = wires.length;
        wire[] wiresObject = new wire[length];

        for (int i = 0; i < length; i++) {
            wiresObject[i] = new wire(wires[i], false);
        }
        for (int i = 0; i < length; i++) {
            // count - (전체 - count) 6-(9-6) = 3
            wiresObject[i].used = true;
            count = 1;
            tracking(1, wiresObject);
            int sub = Math.abs(count - (n - count));
            if ( sub < result ) {
                result = sub;
            }
            wiresObject[i].used = false;
        }
        answer = result;

        return answer;
    }

    public static void main(String[] args) {

        전력망을_둘로_나누기 전력망을_둘로_나누기 = new 전력망을_둘로_나누기();
        int solution = 전력망을_둘로_나누기.solution(4, new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(solution);

    }


}
