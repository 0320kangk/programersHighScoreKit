package sort;

import com.sun.tools.attach.AttachNotSupportedException;

public class H_Index {

    public int solution(int[] citations) {

        int answer = 0;

        int length = citations.length;
        int h = length;

        // [1,1,1,2,2]
        while (h > 0) {
            //인용된 논문 수
            int quotationCount = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    quotationCount++;
                }
            }
            if ( quotationCount >= h  && length - quotationCount <= h ) {
                answer = h;
                break;
            }
            h--;
        }

        return answer;
    }

    public static void main(String[] args) {

        H_Index h_index = new H_Index();
        int solution = h_index.solution(new int[]{0,1,1});
        System.out.println(solution);

    }

}
