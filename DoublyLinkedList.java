package assignment_3;

import java.util.Scanner;

public class DoublyLinkedList {
    Song head;

    public void addSong(Scanner input) {
        System.out.println("**************** Add a New Song ******************");
        System.out.print("Enter song title: ");
        String title = input.nextLine().trim();
        System.out.print("Enter song artist: ");
        String artist = input.nextLine().trim();

        Song song = new Song(title, artist);
        if (head == null) {
            head = song;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = song;
            song.prev = current;
        }
        System.out.println("Song " + title + " by " + artist + " has been successfully added.");
        System.out.println();
    }

    public boolean removeSong(Scanner input) {
        System.out.println("**************** Delete a Song ******************");
        System.out.println("Enter title of song you wish to delete: ");
        String title = input.nextLine().trim();

        if (head == null) {
            System.out.println("There are no songs in the playlist");
        } else {
            Song current = head;
            Song previous = current.prev;
            while (current != null) {
                if (current.title.equals(title)) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
        return false;
    }

    public Song playNext(Scanner input, Song song) {
        if (head == null) {
            System.out.println("There are no songs in this playlist.");
        } else if (song == null) {
            return head;
        } else {
            Song current = head;
            while (current != null) {
                if (current.title.equals(song.title) && current.next == null) {
                    return current;
                }else if (current.title.equals(song.title)) {
                    return current.next;
                } else {
                    current = current.next;
                }
            }
        }
        return null;
    }

    public Song playPrevious(Scanner input, Song song) {
        if (head == null) {
            System.out.println("There are no songs in this playlist.");
        } else if (song == null) {
            return head;
        } else {
            Song current = head;
            while (current != null) {
                if (current.title.equals(song.title) && current == head) {
                    return current;
                } else if (current.title.equals(song.title)) {
                    return current.prev;
                } else {
                    current = current.next;
                }
            }
        }
        return null;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("There are no songs in this playlist.");
        } else {
            Song current = head;
            System.out.println("**************** Song Playlist ******************");
            while (current != null) {
                System.out.printf("Title: %s, Artist: %s\n", current.title, current.artist);
                System.out.println();
                current = current.next;
            }
        }
    }
}
