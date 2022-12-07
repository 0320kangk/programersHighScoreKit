package hash;

import java.util.*;
import java.util.stream.Collectors;

public class 전화번호_목록 {

    public boolean solution(String[] phone_book) {


        Map<String, Integer> phoneBookMap = Arrays.stream(phone_book)
                .collect(Collectors.toMap(pb -> pb, pb -> 1));

        for ( String s : phoneBookMap.keySet()) {

            for (int i = 1; i < s.length(); i++) {
                if (phoneBookMap.containsKey(s.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;

    }
    public static void main(String[] args) {

        전화번호_목록 전화번호_목록 = new 전화번호_목록();
        boolean solution = 전화번호_목록.solution(new String[]{"1234","456","126"});
        System.out.println(solution);


    }
}
