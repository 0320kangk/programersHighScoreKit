package hash;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범{

    class Music{
        int playCount;
        int index;
        String genre;

        public Music(String genre, int playCount, int index) {
            this.playCount = playCount;
            this.index = index;
            this.genre = genre;
        }
    }
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genresHashMap = new HashMap<>();
        int length = genres.length;
        Music[] musics = new Music[length];
        for (int i = 0; i < length; i++) {

            String genre = genres[i];
            int play = plays[i];
            genresHashMap.put(genre, genresHashMap.getOrDefault(genre, 0) + play);
            musics[i] = new Music(genre, play, i);

        }

        List<String> sortedGenres = genresHashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(key -> {
                    return key.getKey();
                })
                .collect(Collectors.toList());
        //장르별 가장 큰, 장르별 musics


        List<Music> playCountMusics = Arrays.stream(musics)
                .sorted(Comparator.comparing((object) -> {
                    Music music = (Music) object;
                    return music.playCount;
                }).reversed())
                .collect(Collectors.toList());

        int genreCount = 0;
        List<Integer> answerList = new ArrayList<>();
        for (String sortedGenre : sortedGenres) {
            for (Music playCountMusic : playCountMusics) {
                if ( genreCount < 2 && playCountMusic.genre.equals(sortedGenre) ) {
                    answerList.add(playCountMusic.index);
                    genreCount++;
                }
            }
            genreCount = 0;
        }
        int[] answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();


        return answer;

        }

    public static void main(String[] args) {
        베스트앨범 베스트앨범 = new 베스트앨범();
        int[] solution = 베스트앨범.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(solution));
    }





}

