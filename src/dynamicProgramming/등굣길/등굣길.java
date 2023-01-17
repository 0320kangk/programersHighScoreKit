package dynamicProgramming.등굣길;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] location = new int[n][m];

        location[0][0] = 1;
        for (int[] puddle : puddles) {
            location[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = 0; //왼쪽 값
                int b = 0; //위쪽 값
                if ( i != 0 || j != 0) {
                    if ( i != 0 ) {
                        b = location[i-1][j];
                    }
                    if ( j != 0) {
                        a = location[i][j-1];
                    }
                    location[i][j] = location[i][j] != -1 ? (a + b) % 1000000007 : 0;
                }
            }
        }
        answer = location[n-1][m-1];
        return answer;
    }
}
