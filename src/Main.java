import com.deependra.Album;
import com.deependra.Song;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

      Album album = new Album("Album1","AC/DC");
      album.addSong("TNT",4.5);
      album.addSong("Zinda h to",3.5);
      album.addSong("Bhag Milkha Bhag",5.5);
      albums.add(album);

      album = new Album("Album2","Eminem");
        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",2.5);
        album.addSong("Lose yourself",4.59);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT", playList_1);
        albums.get(0).addToPlayList("Zinda h to", playList_1);
        albums.get(0).addToPlayList("Bhag Milkha Bhag", playList_1);
        albums.get(0).addToPlayList("Rap god", playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else{
            System.out.println("Now playing "+ listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action  = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else{
                        System.out.println("no song available, reached end of the songs");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = true;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else{
                        System.out.println("We are the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing"+ listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("we are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());

                        }else{
                            if(listIterator.hasPrevious())
                            System.out.println("Now playing "+listIterator.previous().toString());
                        }
                    }
                    break;

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available songs\n"+
                "6 - delete current song");

    }
    private static void printList(LinkedList<Song>playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("____________________________");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________________________");
    }
}