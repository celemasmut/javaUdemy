package udemy.playLinkedlist;

import java.util.*;

public class Main {
     private static ArrayList<Album> albums = new ArrayList<Album>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //ArrayList<Album> albums = new ArrayList<>();

        Album album = new Album("alguno","cualka");
        album.addSong("alguno",3.4);
        album.addSong("alguno2",6.4);
        album.addSong("alguno3",4.4);
        album.addSong("alguno4",3.7);
        album.addSong("alguno5",5.4);
        album.addSong("alguno6",2.4);
        album.addSong("alguno7",3.5);

        albums.add(album);

        album = new Album("qeseyo","cuak");
        album.addSong("qeseyo1",3.4);
        album.addSong("qeseyo2",6.4);
        album.addSong("qeseyo3",4.4);
        album.addSong("qeseyo4",3.7);
        album.addSong("qeseyo5",5.4);
        album.addSong("qeseyo6",2.4);
        album.addSong("qeseyo7",3.5);

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("alguno2",playList);
        albums.get(0).addToPlayList("alguno6",playList);
        albums.get(0).addToPlayList("alguno4",playList);
        albums.get(1).addToPlayList(5,playList);
        albums.get(1).addToPlayList(2,playList);

        play(playList);

    }

    private static  void play(LinkedList<Song> playlist){
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No song in playList");
        }else{
            System.out.println("Now playing " +listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = scan.nextInt();;
            scan.nextLine();

            switch (action){
                case 0:
                    System.out.println("playList complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now playing "+ listIterator.next().toString());
                    }else{
                        System.out.println("we have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now playing "+listIterator.previous().toString());
                    }else{
                        System.out.println("we are at the start of the playList");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now replaying "+listIterator.next().toString());
                            forward=true;
                        }else{
                            System.out.println("we have reached end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0 ){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("now playing "+listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list song in the playList\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===========================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
    }

}
