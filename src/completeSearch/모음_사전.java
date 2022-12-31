package completeSearch;

import java.util.ArrayList;
import java.util.Collections;

public class 모음_사전 {

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

//    public int solution(String word) {
//        int answer = 0;
//        String aeiou = "AEIOU";
//        String[] split = word.split("");
//        int total = 3905;
//        int result = 0;
//        for (String s : split) {
//            total/=5;
//            result += total * aeiou.indexOf(s) + 1;
//        }
//        answer = result;
//        return answer;
//    }


    //AAAAA, 5,25,125,625,3125 // 1자리,2자리 3자리 4자리 5자리 경우의 수
    //A로 시작하는 단어는 3905/5 = 781개, 각 각 781 개 EAAA, 781*1+
    //1,(5+1), (5+1)*5+1,//AAAXX

    public void combination(int index, String str) {
        if (index>=5)return;
        for(int i = 0; i < alphabet.length; i++) {
            list.add(str+alphabet[i]);
            combination(index+1, str+alphabet[i]);
        }
    }

    public static void main(String[] args) {
        모음_사전 모음_사전 = new 모음_사전();
        int aaa = 모음_사전.solution("AAAEE");
        System.out.println(aaa);

    }

}
