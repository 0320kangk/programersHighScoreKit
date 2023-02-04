package dfs_bfs.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] used = new boolean[102][102];
        for (int[] rec : rectangle) {
            //행
            rec[0] = rec[0] * 2;
            rec[1] = rec[1] * 2;
            rec[2] = rec[2] * 2;
            rec[3] = rec[3] * 2;
            for (int y = rec[1] + 1; y < rec[3]; y++) {
                //열
                for (int x = rec[0] + 1; x < rec[2]; x++) {
                    used[y][x] = true;
                }
            }
        }
        queue.add(new Integer[]{characterX*2, characterY*2});
        used[characterY*2][characterX*2] = true;
        int move = 0;
        int neighborNode = queue.size();
        for(Integer[] location = queue.poll();
        location[0] != itemX*2 || location[1] != itemY*2;
        location = queue.poll()) {
            neighborNode--;
            for (int[] rec : rectangle) {
                //오론쪽 1칸
                if ( (location[0] + 1 >= rec[0] && location[0] + 1 <= rec[2]) && (
                        location[1] == rec[1] || location[1] == rec[3] ) &&
                used[location[1]][location[0]+1] == false
                ) {
                    used[location[1]][location[0]+1] = true;
                    queue.add(new Integer[] {location[0] + 1, location[1]});
                }
                //왼쪽 1칸
                if ( (location[0] -1 >= rec[0] && location[0] - 1 <= rec[2]) && (
                        location[1] == rec[1] || location[1] == rec[3] ) &&
                        used[location[1]][location[0]-1] == false
                ) {
                    used[location[1]][location[0]-1] = true;
                    queue.add(new Integer[] {location[0] - 1, location[1]});
                }
                //위쪽 1칸
                if ( (location[0] == rec[0] || location[0] == rec[2]) && (
                        location[1] + 1 >= rec[1] && location[1] + 1 <= rec[3] ) &&
                        used[location[1]+1][location[0]] == false
                ) {
                    used[location[1]+1][location[0]] = true;
                    queue.add(new Integer[] {location[0], location[1]+1});
                }
                //아래쪽 1칸
                if ( (location[0] == rec[0] || location[0] == rec[2]) && (
                        location[1] - 1 >= rec[1] && location[1] - 1 <= rec[3] ) &&
                        used[location[1]-1][location[0]] == false
                ) {

                    used[location[1]-1][location[0]] = true;
                    queue.add(new Integer[] {location[0], location[1] - 1});
                }
            }
            if (neighborNode == 0) {
                neighborNode = queue.size();
                move++;
            }
        }
        answer = move/2;
        return answer;
    }

    public static void main(String[] args) {
        아이템_줍기 아이템_줍기 = new 아이템_줍기();
        int solution = 아이템_줍기.solution(new int[][]{{2, 2, 5, 5},{1,3,6,4},{3,1,4,6}}, 1, 4, 6, 3);
        System.out.println(solution);
    }

}
