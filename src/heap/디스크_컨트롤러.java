package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {


    public int solution(int[][] jobs) {

//        시점, 수행시간
//        jobs를 시점순으로 정렬한다.
//        작업을 하나 꺼내고 그 작업의 시점보다 낮은 모든 작업을
//        우선순위 큐에 넣는다. 우선순위 기준은 작업시간이다.
//        그 다음 가장 우선순위가 높은 작업을 하나 꺼내어 시간을 계산한다.
//        poll 할 때마다 카운팅하여 총 몇번의
//        작업 중 대기중인 jobs 를 꺼내 큐에 넣고 우선순위를 다시 정한다.
//        만약 우선순위 큐가 비었다면 그 말은 현재 시점에서 작업할 수 있는 job이 없으므로
//        최신 jobs를 꺼내 다시 연산을 수행한다.
//        같은 대기시간이면 우선수위 큐에 들어가 정렬된다.

        //위치
        int location = 0;
        //수행되고난 직후의 시간
        int end = 0;

        int totalTime = 0;

        int count = 0;
        //요청시점으로 정렬하기
        Arrays.sort(jobs, (job1, job2) -> job1[0]-job2[0]);

        //작업시간으로 정렬하기
        PriorityQueue<int[]> workingQueue = new PriorityQueue<>( (job1, job2) -> job1[1]-job2[1] );

        while( count < jobs.length) {

            //수행이되고난 직후의 시간보다 작은 모든 것을 큐에 넣어버리귀~
            while( location < jobs.length && jobs[location][0] <= end  ) {
                workingQueue.add(jobs[location++]);
            }

            //기달린시간 + 수행시간
            if (!workingQueue.isEmpty()){
                int[] poll = workingQueue.poll();
                totalTime += end + poll[1] - poll[0] ;
                end += poll[1];
                count++;

            }
            //비어있다면 end를 대기시간이 가장 컷던 경우에 맞춰주기
            else {
                end = jobs[location][0];
            }

        }


        int answer = totalTime / jobs.length;
        return answer;

    }

    /**
     * 원본 배열을 요청시점으로 정렬한다.
     * 작업시간기준으로 정렬하는 우선순위 큐를 만든다.
     * 원본배열에서 꺼낸
     */

    public static void main(String[] args) {
        디스크_컨트롤러 디스크_컨트롤러 = new 디스크_컨트롤러();
        int solution = 디스크_컨트롤러.solution(new int [][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println(solution);
    }
}
