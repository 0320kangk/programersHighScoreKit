package stack.기능개발;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int progress : progresses) {
            queue.add(progress);
        }
        int index = 0;
        List<Integer> list = new ArrayList<>();
        int days = (int) Math.ceil((100.0 - progresses[index])/speeds[index]);
        int count = 0;
        System.out.println(days);
        while (!queue.isEmpty()){
                if ( days >= (int) Math.ceil((100.0 - progresses[index])/speeds[index] )) {
                    queue.poll();
                    count++;
                    index++;
                } else {
                    days = (int) Math.ceil((100.0 - progresses[index])/speeds[index]);
                    list.add(count);
                    count = 0;
                }
        }
        list.add(count);
        return list.stream()
                .mapToInt((num) -> num)
                .toArray();
    }

    public static void main(String[] args) {
        기능개발 기능개발 = new 기능개발();
        int[] solution = 기능개발.solution(new int[]{95,94}, new int[]{3,3});
        System.out.println(Arrays.toString(solution) );
    }
}
