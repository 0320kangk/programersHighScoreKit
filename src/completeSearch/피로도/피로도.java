package completeSearch.피로도;

public class 피로도 {
    boolean[] used;
    int max = 0;
    void search(int k, int[][] dungeons, int count) {
        if ( count > max){
            max = count;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (!used[i] && k >= dungeons[i][0] ) {
                used[i] = true;
                search( k-dungeons[i][1],dungeons, count + 1);
                used[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        used = new boolean[dungeons.length];
        search(k, dungeons, 0);
        return max;
    }
    /*boolean[] dungeonsUse;
    int size;
    int totalCount = 0;


    void tracking(int fatigue, int[][] dungeons, int count ) {

        if ( count > totalCount ) {
            totalCount =count;
        }

        for(int i = 0; i < size; i++) {
            if (!dungeonsUse[i] && fatigue >= dungeons[i][0] ) {
                dungeonsUse[i] = true;
                fatigue -= dungeons[i][1];
                tracking(fatigue, dungeons, count + 1);
                fatigue += dungeons[i][1];
                dungeonsUse[i] = false;
            }
        }

    }
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        size = dungeons.length;
        dungeonsUse = new boolean[size];
        tracking(k, dungeons, 0);
        answer = totalCount;
        return answer;
    }
    */
    public static void main(String[] args) {

        피로도 피로도 = new 피로도();
        int solution = 피로도.solution(80, new int[][]{ {50, 40},{80, 20}, {30, 10}});
        System.out.println(solution);

    }



}
