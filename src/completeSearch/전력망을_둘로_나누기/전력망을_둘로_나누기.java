package completeSearch.전력망을_둘로_나누기;

public class 전력망을_둘로_나누기 {
    int dfs(int n, wire[] wires,int linked) {
        for (int i = 0; i < wires.length; i++) {
            if (wires[i].used == false &&
                    (wires[i].point[0] == n ||
                    wires[i].point[1] == n)) {
                wires[i].used = true;
                if(wires[i].point[0] == n) {
                    linked = dfs(wires[i].point[1], wires, linked + 1);
                } else {
                    linked = dfs(wires[i].point[0], wires, linked + 1);
                }
                wires[i].used = false;
            }
        }
        return linked;
    }
    public int solution(int n, int[][] wires) {
        int answer = 100;

        //가장 차이가 적게 2개의 송전탑 연결을 만드는 문제
        //하나씩 끊어봐서 해보기? 이게 정배 같기도 한데
        //이 중에서 가장 차이가 적은 것을 찾기?이 방법이 정배인듯?

        wire[] wireObjects = new wire[wires.length];
        for (int i = 0; i < wireObjects.length; i++) {
            wireObjects[i] = new wire(wires[i], false);
        }
        for (int i = 0; i < wireObjects.length; i++) {
            wireObjects[i].used = true;
            int linked = dfs(1, wireObjects, 1);
            int dif = Math.abs((n - linked) - linked);
            if ( answer > dif) {
                answer = dif;
            }
            wireObjects[i].used = false;
        }

        return answer;
    }
    class wire {
        int[] point;
        boolean used;

        public wire(int[] point, boolean used) {
            this.point = point;
            this.used = used;
        }
    }
    public static void main(String[] args) {
        전력망을_둘로_나누기 전력망을_둘로_나누기 = new 전력망을_둘로_나누기();
        int solution = 전력망을_둘로_나누기.solution(4, new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(solution);
    }
}
