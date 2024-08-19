package jukebox.DAOImpl;
import jukebox.model.Playlist;
import jukebox.model.song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void mainMenu() throws SQLException {
        music display = new music();//obj of display utilitiess
        //---------------------------------------------------//
        String playlistname="";
        String finalsongs="";
        int songId=0;
        Playlist playlist=null;
        String songsId="";
        String Input = "";
        //System.out.println("Bliss Music");
        int selection;
        Scanner sc = new Scanner(System.in);
        ArrayList<song> songslist = Details.songs();
        System.out.println("Press 1 to View All Songs And Enjoy");
        System.out.println("Press 2 to Search songs By Name");
        System.out.println("Press 3 to Search songs By Genre");
        System.out.println("Press 4 to Search songs By Artist");
        System.out.println("Press 5 to Create Personalised Playlist");
        System.out.println("Press 6 to Your Playlist");
        System.out.println("Press 7 to Exit");
        selection = sc.nextInt();

        switch (selection) {
            case 1: {
                ArrayList<song> list = Details.songs();
                display.displaySongs(songslist);
                main.playSong(list);
                main.mainMenu();
            }
            break;
            case 2: {
                display.displaySongs(songslist);
                System.out.println("Enter Song name To Search");
                Input = sc.next();
                ArrayList<song> searchSongs = Details.Searchsong(Input);
                display.displaySongs(searchSongs);
                main.playSong(searchSongs);
                main.mainMenu();
            }
            break;
            case 3: {
                display.displaySongs(songslist);
                System.out.println("Enter Genre name to Search");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<song> searchSongs = Details.SearchByGenre(Input);
                display.displaySongs(searchSongs);
                main.playSong(searchSongs);
                main.mainMenu();
            }
            break;
            case 4: {
                display.displaySongs(songslist);
                System.out.println("Enter Artist name to Search");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<song> searchSongs = Details.SearchByArtist(Input);
                display.displaySongs(searchSongs);
                main.playSong(searchSongs);
                main.mainMenu();
            }
            break;
            case 5:
            {
                display.displaySongs(songslist);
                int songId1;
                System.out.println("Enter Playlist Names :");
                String playlistName = sc.nextLine();
                playlistName=sc.nextLine();
//                System.out.println("Enter Playlist Id");
   //             int playlistId = sc.nextInt();
                System.out.println(" Your playlist created");
                do {
                    System.out.println("enter songId or press 0 to exit" );
                    songId1=sc.nextInt();
                    boolean insert= createPlaylist.createSongs(playlistName, songId1);
                    if(!insert)
                    {
                        System.out.println("Song Id Inserted");
                    }

                }
                while(songId1!=0);
                main.mainMenu();
            }
            break;

            case 6:{
                Details.viewPlaylist();
                System.out.println("Enter Your playlist name to view");
                String playlistName = sc.next();
                ArrayList<song>list=music.displayPlaylist(playlistName);
                music.displaySongs(list);
                main.playSong(list);
               main.mainMenu();
            }
            break;

        }

    }

    public static void playSong(ArrayList<song>Music) throws SQLException {
        Scanner sc=new Scanner(System.in);

        System.out.println("Press 1 to play all song");
        System.out.println("Press 2 to play Select song");
        System.out.println("Press 3 to Main menu");
        try {
        int opt = sc.nextInt();
        int songId=0;

            switch (opt) {

                case 1:
                    AudioPlay.playList(Music);
                    break;
                case 2: {
                    System.out.println("Enter song id");
                    songId = sc.nextInt();
                    AudioPlay.playSong(Music, songId);
                }
                break;
                case 3: {
                    main.mainMenu();
                    break;
                }
                default:System.out.println("Enter valid response ");

            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Thank you");
    }

}
