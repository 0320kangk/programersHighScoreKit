package greedy.섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;
public class 섬_연결하기 {
    int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return findParent(parent, parent[node]);
    }
    void union(int[] parent, int node1, int node2) {
        int parentNode1 = findParent(parent ,node1);
        int parentNode2 = findParent(parent, node2);

        if (parentNode1 < parentNode2) {
            parent[parentNode2] = parentNode1;
        } else {
            parent[parentNode1] = parentNode2;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, Comparator.comparing(cost -> cost[2]));
        for (int i = 0; i < costs.length; i++) {
            if (findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
                answer += costs[i][2];
                union(parent ,costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        섬_연결하기 섬_연결하기 = new 섬_연결하기();
        int solution = 섬_연결하기.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2,3,8}});
        System.out.println(solution);
    }
}
