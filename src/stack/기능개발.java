package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {

        int length = progresses.length;
        int[] workingDate = new int[length];

        for (int i = 0; i < length; i++) {
            workingDate[i] = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
        }

        int num = workingDate[0];
        int workDate = 1;
        List<Integer> workDates = new ArrayList<>();
        System.out.println(Arrays.toString(workingDate));
        for (int i = 1; i < length; i++) {
            if ( num >= workingDate[i]) {
                workDate++;
            } else {

                workDates.add(workDate);
                num=workingDate[i];
                workDate = 1;
            }
        }
        workDates.add(workDate);


        int[] answer = workDates.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;

    }

    public static void main(String[] args) {
        기능개발 기능개발 = new 기능개발();
        int[] solution = 기능개발.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(solution) );
    }


}
