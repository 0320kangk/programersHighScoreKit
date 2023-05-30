package sort.H_Index;

public class H_Index {

    public int solution(int[] citations) {

        int h = citations.length;
        int count = 0;
        //논문 h번 이상 논문 h번 개수 이상 만족, 나머지 h 이하 인용
        while ( true ) {
            count=0;
            for (int citation : citations) {
                if (citation >= h) {
                    count++;
                }
            }
            if (count >= h) {
                return h;
            }
            h--;
        }
    }

    public static void main(String[] args) {

        H_Index h_index = new H_Index();
        int solution = h_index.solution(new int[]{0,1,1});
        System.out.println(solution);

    }

}
