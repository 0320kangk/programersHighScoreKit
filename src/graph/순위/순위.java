package graph.순위;

public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1; //이김
        }
        //i = 거쳐가는(길), j 시작점 k 끝점
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if( graph[j][i] == 1 && graph[i][k] == 1 ) {
                        graph[j][k] = 1;
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                sum += graph[i][j] + graph[j][i];
            }
            if (sum == n - 1) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        순위 순위 = new 순위();
        int solution = 순위.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
        System.out.println(solution);
    }
}
