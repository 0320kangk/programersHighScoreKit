package completeSearch.최소직사각형;

import java.util.Arrays;

public class 최소직사각형 {

    public int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            int preValue = sizes[i][0];
            if ( sizes[i][0] > sizes[i][1] ){
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = preValue;
            }
        }
        Arrays.sort( sizes, (a,b) -> (b[0]-a[0]));
        int width = sizes[0][0];
        Arrays.sort( sizes, (a,b) -> (b[1] - a[1]));
        int height = sizes[0][1];
        return width * height;

        /*
         지갑 중 가장 큰 가로를 선택한다. (가로보다 더 큰 세로는 지갑을 돌린다).
         돌린 지갑중에서 가장 큰 세로를 찾는다.
         이 방법이 가로와 세로의 차이가 가장큰 직사각형이다.
         차이가 커야 가장 작은 넓이의 직사각형이 나온다.
         */
/*

        return Arrays.stream(sizes)
                .reduce((a,b) -> new int[]{
                        Math.max(  Math.max(a[0],a[1]), Math.max(b[0],b[1])),
                        Math.max( Math.min(a[0],a[1]), Math.min(b[0],b[1]))
                })
                .map( result -> result[0] *result[1]).get();*/
    }

    public static void main(String[] args) {
        최소직사각형 최소직사각형 = new 최소직사각형();
        int solution = 최소직사각형.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(solution);
    }

}
