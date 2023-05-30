package completeSearch.카펫;

import java.util.Arrays;

public class 카펫 {

    public int[] solution(int brown, int yellow) {

        int xySum = (brown-4)/2; //yellow, 밑변 + 높이
        int[] answer = new int[2];
        for (int x = xySum/2 + 1; 0 < x; x--) {
            int y = xySum - x;
            if ( x * y == yellow) {
                answer[0] = x+2;
                answer[1] = y+2;
                break;
            }
        }
        return answer;



















        /*
        1개일 때를 제외하고
        노랑색은 짝수 개수여야 한다.
        가로가 더 커야 한다.
        몫 = 열의 개수 (노란색 가로)
        나누는 값이 행의 개수 (노란색 세로)
        갈색 개수 = 열 * 2 + 행 * 2 + 4
         */
      /*  int[] answer = new int[2];
        int yellowColumn;
        int remainder;
        int brownCount;
        for (int yellowRow = 1; yellowRow <= yellow; yellowRow++) {
            remainder = yellow % yellowRow;
            if ( remainder == 0) {
                yellowColumn = yellow / yellowRow;
                brownCount = (yellowColumn + yellowRow) * 2 + 4;
                if ( brownCount == brown ) {
                    answer[0] = yellowColumn + 2;
                    answer[1] = yellowRow + 2;
                    break;
                }
            }
        }
        return answer;*/
    }



    public static void main(String[] args) {

        카펫 카펫 = new 카펫();
        int[] solution = 카펫.solution(8, 1);
        System.out.println(Arrays.toString(solution));

    }

}
