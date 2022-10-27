import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04_Songs {
    static class Song {
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return this.name;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public String getTime() {
            return this.time;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> listSong = new ArrayList<>();
        for (int i = 0; i < numberOfSongs; i++) {
            String inputLine = scanner.nextLine();
            String[] inputSongArr = inputLine.split("_");

            Song currSong = new Song(inputSongArr[0], inputSongArr[1], inputSongArr[2]);
            listSong.add(currSong);
        }
        String command = scanner.nextLine();
        if(command.equals("all")) {
            for (Song item : listSong) {
                System.out.println(item.getName());
            }
        } else {
            for (Song item : listSong) {
                if(item.getTypeList().equals(command)) {
                    System.out.println(item.getName());
                }
            }
        }
    }
}

