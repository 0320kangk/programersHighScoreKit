package dfs_bfs.여행경로;

import java.util.*;

public class 여행경로 {

    boolean used[];
    ArrayList<String> answerList;
    void dfsSearch(String start, String route, String[][] tickets ,int cnt) {

        if ( cnt == tickets.length) {
            answerList.add(route);
            return;
        }
        for (int i = 0 ; i < tickets.length ;i++) {
            if ( !used[i] && start.equals(tickets[i][0]) ) {
                used[i] = true;
                dfsSearch(tickets[i][1], route + " " + tickets[i][1],tickets,cnt+ 1);
                used[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        answerList = new ArrayList<String>();
        used = new boolean[tickets.length];
        if (tickets[0][0] != null) {
            dfsSearch("ICN" ,"ICN", tickets, 0);
        }
        Collections.sort(answerList);
        return answerList.get(0).split(" ");
    }
    public static void main(String[] args) {
        여행경로 여행경로 = new 여행경로();
        여행경로.solution(new String[][] {{"ICN", "SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}});

    }
}
