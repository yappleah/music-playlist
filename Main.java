package assignment_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList playlist = new DoublyLinkedList();
        Scanner scan = new Scanner(System.in);
        Song playingSong = null;
        int input;
        do {
            System.out.println("************ SONG PLAYLIST **************");
            System.out.println("1 - Add a new song");
            System.out.println("2 - Delete a song");
            System.out.println("3 - Play next song");
            System.out.println("4 - Play previous song");
            System.out.println("5 - Display Playlist");
            System.out.println("6 - Exit");
            input = Integer.parseInt(scan.nextLine().trim());

            switch (input) {
                case 1:
                    playlist.addSong(scan);
                    break;
                case 2: 
                    boolean deleted = playlist.removeSong(scan);
                    if (deleted) {
                        System.out.println("Song has been successfully deleted.");
                    } else {
                        System.out.println("Song does not exist in this playlist.");
                    }
                    System.out.println();
                    break;
                case 3:
                    playingSong = playlist.playNext(scan, playingSong);
                    System.out.println("The current song playing is: " + playingSong.title + " by " + playingSong.artist);
                    break;
                case 4:
                    playingSong = playlist.playPrevious(scan, playingSong);
                    System.out.println("The current song playing is: " + playingSong.title + " by " + playingSong.artist);
                    break;
                case 5:
                    playlist.displayPlaylist();
                    break;
            }

        } while (input != 6);
    }
}
