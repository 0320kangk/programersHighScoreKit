package dfs_bfs.타겟_넘버;

public class 타겟_넘버 {
    int count = 0;
    void tracking(int num, int dep, int[] numbers, int target) {
        if ( dep == numbers.length ) {
            if (num == target)
                count++;
            return;
        }
        tracking(num + numbers[dep],dep + 1, numbers, target);
        tracking(num - numbers[dep],dep + 1, numbers, target);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        tracking(0,0,numbers,target);
        answer = count;
        return answer;
    }

    public static void main(String[] args) {
        타겟_넘버 타겟_넘버 = new 타겟_넘버();
        int solution = 타겟_넘버.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println(solution);
    }
}
