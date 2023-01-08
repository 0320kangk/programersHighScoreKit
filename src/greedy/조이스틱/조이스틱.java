package greedy.조이스틱;

public class 조이스틱 {

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for ( int i = 0; i < name.length(); i++ ) {
            answer += Math.min( name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A') );
            if ( i + 1 < name.length() && name.charAt( i + 1) == 'A' ) {
                int endA = i + 1;
                while ( endA < name.length() && name.charAt(endA) == 'A' ) {
                    endA++;
                }
                //우->좌
                move = Math.min(move, i * 2+(name.length() - endA));
                //좌->우
                move =  Math.min(move, (name.length() - endA) * 2 + i);
            }
        }
        return answer + move;
    }
    public static void main(String[] args) {

        조이스틱 조이스틱 = new 조이스틱();
        int jeroen = 조이스틱.solution("BBBABAAAAAAAAAAAAAB");//9+10+10+10
        System.out.println(jeroen);
    }
}
