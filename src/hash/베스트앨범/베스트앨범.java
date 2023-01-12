package hash.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범{

    class Music {
        int index;
        int play;
        String genre;

        public Music(int index, int play, String genre) {
            this.index = index;
            this.play = play;
            this.genre = genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int size = genres.length;
        Music[] musics = new Music[size];
        HashMap<String, Integer> genresMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            musics[i] = new Music(i, plays[i], genres[i]);
        }

        List<String> genreList = genresMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(key -> key.getKey())
                .collect(Collectors.toList());
        Arrays.sort(musics, Comparator.comparing(music -> music.play, Comparator.reverseOrder()));
        ArrayList<Integer> uniqueNums = new ArrayList<>();
        for (String genre : genreList) {
            int genreCount = 0;
            for (Music music : musics) {
                if ( genreCount < 2 && music.genre.equals(genre)) {
                    uniqueNums.add(music.index);
                    genreCount++;
                }
            }
        }
        int[] answer = uniqueNums.stream()
                .mapToInt(num -> num)
                .toArray();
        return answer;

        }
    public static void main(String[] args) {
        베스트앨범 베스트앨범 = new 베스트앨범();
        int[] solution = 베스트앨범.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(solution));
    }
}

