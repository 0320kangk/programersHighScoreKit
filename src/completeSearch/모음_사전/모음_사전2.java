package completeSearch.모음_사전;

import java.util.ArrayList;

public class 모음_사전2 {
    char[] alphabet = {'A','E','I','O','U'};
    ArrayList<String> list;
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;

        combination(0, "");
//        Collections.sort(list);
        answer = list.indexOf(word)+1;

        return answer;
    }
    public void combination(int index, String str) {
        if (index>=5)return;
        for(int i = 0; i < alphabet.length; i++) {
            list.add(str+alphabet[i]);
            combination(index+1, str+alphabet[i]);
        }
    }

    public static void main(String[] args) {
        모음_사전2 모음_사전2 = new 모음_사전2();
        int aaa = 모음_사전2.solution("AAAEE");
        System.out.println(aaa);

    }

}
