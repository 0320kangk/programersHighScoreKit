package hash.완주하지_못한_선수;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {

        String answer = "";

        Map<String, Integer> collect = Arrays.stream(participant)
                .collect(Collectors.toMap((p) -> p,
                        (p) -> 1, (oldValue, newValue) ->{
                    return newValue += oldValue;
                }));

        for (String key : completion) {
            if ( collect.get(key) > 0 ) {
                    collect.put(key, collect.get(key) -1);
            }
        }

        for (String key : collect.keySet()) {
            if ( collect.get(key) > 0 ) {
                return answer = key;
            }
        }

        return answer = "";

//        String answer = "";
//        List<String> participantList = new ArrayList<String>(Arrays.asList(participant));
//        List<String> completionList = new ArrayList<String>(Arrays.asList(completion));
//
//        for (String s : participantList) {
//
//            if (!completionList.contains(s)) {
//                answer = s;
//            }
//            completionList.remove(s);
//
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        완주하지_못한_선수 완주하지_못한_선수 = new 완주하지_못한_선수();
        String solution = 완주하지_못한_선수.solution( new String[] {"강준호","강민호","강금준"},
                new String[] {"강준호","강민호"});
        System.out.println(solution);
    }



}
