package graph.가장_먼_노드;

import java.util.*;

public class 가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        int[] visited = new int[n+1];
        List<Integer>[] edgeList = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            edgeList[edge[i][0]].add(edge[i][1]);
            edgeList[edge[i][1]].add(edge[i][0]);
        }
        //인덱스 0: 노드 위치, 인덱스 1: 거리
        Queue<Integer[]> q = new LinkedList<>();
        int distinct = 0;
        q.add(new Integer[] {1, 1});
        visited[1] = 1;
        while(!q.isEmpty()) {
            Integer[] poll = q.poll();
            if (distinct < poll[1])
                distinct = poll[1];
            for (int i = 0; i < edgeList[poll[0]].size(); i++) {
                int next = edgeList[poll[0]].get(i);
                if ( visited[next] == 0 ) {
                    visited[next] = poll[1] + 1;
                    q.add(new Integer[] {next, poll[1] + 1});
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == distinct) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        가장_먼_노드 가장_먼_노드 = new 가장_먼_노드();
        int solution = 가장_먼_노드.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(solution);
    }
}
