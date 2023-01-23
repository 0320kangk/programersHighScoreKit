package dfs_bfs.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        int col = maps[0].length;//열
        int row = maps.length;//행
        int move = 0;
        int width = 1;
        queue.add(new Integer[] {0, 0});
        maps[0][0] = 0;
        while(!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            width--;
            //poll, 0은 행, 1은 열
            Integer x = poll[0];
            Integer y = poll[1];

            System.out.println(x+ ":" + y);
            //아래
            if ( x + 1 < row && maps[x + 1][y] == 1 ) {
                //아래 한칸
                queue.add(new Integer[] {x+1, y});
                maps[x+1][y] = 0;
            }
            //오른쪽
            if ( y + 1 < col && maps[x][y+1] == 1 ) {
                //오른쪽 한칸
                queue.add(new Integer[] {x, y+1});
                maps[x][y+1] = 0;
            }
            //위
            if ( x > 0 && maps[x - 1][y] == 1 ) {
                //위쪽 한칸
                queue.add(new Integer[] {x-1, y});
                maps[x-1][y] = 0;
            }
            //왼쪽
            if ( y > 0 && maps[x][y-1] == 1 ) {
                //왼쪽 한칸
                queue.add(new Integer[] {x, y-1});
                maps[x][y-1] = 0;
            }

            if ( width == 0 ) {
                width = queue.size();
                move++;
                if ( maps[row -1][col- 1] == 0 ) {
                    move++;
                    break;
                }
            }
        }
        answer = move;
        if ( maps[row-1][col-1] == 1 ) {
            answer = -1;
        }
        return answer;
    }
    public static void main(String[] args) {
        게임_맵_최단거리 게임_맵_최단거리 = new 게임_맵_최단거리();
        int solution = 게임_맵_최단거리.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}});
        System.out.println(solution);
    }
}
