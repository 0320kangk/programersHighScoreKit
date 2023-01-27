package dfs_bfs.단어_변환;

public class 단어_변환 {
    boolean[] used;
    int Min = 51;
    void dfs(int dep,String begin, String target, String[] words) {

        if (begin.equals(target)) {
            if (dep < Min) {
                Min = dep;
            }
            return;
        }
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            int index = 0;
            char c = ' ';
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)){
                    count++;
                    index = j;
                    c = words[i].charAt(j);
                }
            }
            if (count == 1 && used[i] == false ) {
                used[i] = true;
                dfs(dep + 1,begin.substring(0, index) + c + begin.substring(index + 1) ,target, words);
                used[i] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        // 바꿀게 없고 다 사용했다면?
        used = new boolean[words.length];
        dfs(0,begin,target,words);
        answer = Min != 51 ? Min : 0;
        return answer;
    }
    public static void main(String[] args) {
        단어_변환 단어_변환 = new 단어_변환();
        int solution = 단어_변환.solution("hit", "cog", new String[]{"hot", "dot", "dog", "cog"});
        System.out.println(solution);
    }
}
