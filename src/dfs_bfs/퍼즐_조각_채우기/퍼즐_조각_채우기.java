package dfs_bfs.퍼즐_조각_채우기;
import java.util.*;

public class 퍼즐_조각_채우기 {
    class Point implements Comparable<Point> {
        int x;//행
        int y;//열
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        //오름차순 정렬, x가 우선
        public int compareTo(Point o) {

            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }


    public static void main(String[] args) {
        int[][] g1 = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] t1 = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println(new 퍼즐_조각_채우기().solution(g1, t1));
    }

    /*
    1. 게임 보드와 테이블의 조각을 만들어야함
        1-1 조각은 bfs를 이용하여 찾는다.
        1-2 조각은 좌표로 표현한다.
        1-3 dx = (-1,0,1,0) (상 하 이동), dy = (0,1,0,-1) (좌, 우) 이동

    2. 조각을 돌리면서 비교해야 함
    3. 같다면 사이즈 만큼 answer ++
    */
    final int[] dx = {-1,0,1,0};//상하
    final int[] dy = {0,1,0,-1};//우좌

    List<List<Point>> empty_pieces = new ArrayList<>();
    List<List<Point>> table_pieces = new ArrayList<>();
    boolean[][] visited;
    int board_size;
    public int solution(int[][] game_board, int[][] table) {
        board_size = game_board.length;
        visited = new boolean[board_size][board_size];
        //조각을 찾아야 한다.
        //보드판 돌아다니면서 빈공간 찾기
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if ( game_board[i][j] == 0 && !visited[i][j] ) {
                    //type 0 는 빈 공간 찾기
                    empty_pieces.add(check(game_board, i, j, 0));
                }
            }
        }
        //visited 초기화
        visited = new boolean[board_size][board_size];
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if ( table[i][j] == 1 && !visited[i][j] ) {
                    table_pieces.add(check(table, i, j, 1));
                }
            }
        }

        boolean[] visited_board = new boolean[empty_pieces.size()];
        //회전시키면서 똑같은지 비교하기
        //사용 유무도 알아야함
        int answer = 0;
        for (int i = 0; i < table_pieces.size(); i++) {
            List<Point> block_piece = table_pieces.get(i);
            for (int j = 0; j < empty_pieces.size(); j++) {
                List<Point> empty_piece = empty_pieces.get(j);
                if (block_piece.size() == empty_piece.size() &&
                        !visited_board[j] &&
                        isRotate(empty_piece, block_piece)){
                        answer += block_piece.size();
                        visited_board[j] = true;
                        break;
                }
            }
        }

        return answer;
    }

    // 게임 보드의 빈 공간과 테이블의 블록을 찾아내는 메소드
    // 탐색할 배열, 탐색할 인덱스, 게임보드와 테이블 구분하는 변수
    public List<Point> check(int[][] board, int x, int y, int type) {
        Queue<Point> queue = new LinkedList<>();
        //bfs 찾기
        queue.add(new Point(x, y));
        visited[x][y] = true;
        List<Point> results = new ArrayList<>();
        results.add(new Point(0, 0));

        //조각 만들기
        //상하 좌우 이동 시키기
        //공간이 있다면
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if ( nx < board_size && nx >= 0 &&
                    ny < board_size && ny >= 0) {
                    if ( visited[nx][ny] == false && board[nx][ny] == type ){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        //x,y 기준에서의 좌표
                        results.add(new Point(nx - x, ny - y));
                    }
                }
            }
        }
        Collections.sort(results);

        return results;
    }

    // 블록을 회전시키면서 게임 보드에 들어가는지 확인하는 메소드
    public static boolean isRotate(List<Point> empty, List<Point> block) {
        //같은지 비교하기
        for (int i = 0; i < 4; i++) {
            boolean result = true;
            for (int j = 0; j < empty.size(); j++) {
                Point e_point = empty.get(j);
                Point b_point = block.get(j);

                if (e_point.x != b_point.x || e_point.y != b_point.y) {
                    result = false;
                    break;
                }
            }
            if (result)
                return true;

            //회전하기, y=-x대칭, (x, y) => (-y, x)
            for (Point point : block) {
                int tempX = point.x;
                point.x = point.y;
                point.y = -tempX;
            }
            //정렬하기, 똑바로 비교하기 위해
            Collections.sort(block);

            //0,0 재정렬
            int x = block.get(0).x;
            int y = block.get(0).y;

            for (Point point : block) {
                point.x -= x;
                point.y -= y;
            }

        }
        return false;
    }
}