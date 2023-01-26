package dfs_bfs.네트워크;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class 네트워크 {
    int row;
    int col;
    int computersBfs(int i, int[][] computers, Queue<Integer[]> queue) {
        int networkVisit = 0;
        if ( computers[i][i] != 0) {
            networkVisit = 1;
            queue.add(new Integer[] {i, i});
            while (!queue.isEmpty()) {
                Integer[] poll = queue.poll();
                int x = poll[0]; //행, x번 네트워크
                int y = 0; //열, y번 네트워크와 연결
                computers[x][y] = 0;
                System.out.println(x + ":" + y);
                System.out.println(computers[x][y+1]);
                while ( y + 1 < col ) {
                    if (computers[x][y+1] == 1){
                        computers[x][y+1] = 0;
                        computers[y+1][y+1] = 0;
                        queue.add(new Integer[] {y+1, y+1});
                    }
                    y++;
                }
            }
        }
        return networkVisit;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        row = computers.length; //행
        col = computers[0].length; //열
        for (int i = 0; i < row; i++) {
            answer += computersBfs(i, computers, queue);
        }
        for (int[] computer : computers) {
            System.out.println(Arrays.toString(computer));
        }
        return answer;
    }
    public static void main(String[] args) {
        네트워크 네트워크 = new 네트워크();
        int solution = 네트워크.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println(solution);
    }
}
