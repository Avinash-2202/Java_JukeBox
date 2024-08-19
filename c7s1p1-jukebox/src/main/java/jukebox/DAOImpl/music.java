package jukebox.DAOImpl;
import jukebox.connection.getConnection;
import jukebox.model.Playlist;
import jukebox.model.song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
public class music {


        public static void displaySongs(ArrayList<song> Songs) {
            Iterator<song> i = Songs.iterator();
            song song;
            System.out.println("+--------------------------------------------------------------------------------------------------------------+");
            System.out.printf("|  %-10s |  %-30s |  %-25s |  %-15s  | %-10s  |%n", "SongId", "Song Name", "Artist", "Genre", "duration");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            while (i.hasNext()) {
                song = i.next();

                System.out.printf("|  %-10s |  %-30s |  %-25s |   %-15s  | %-10s |%n", song.getSongId(), song.getSongName(), song.getArtist(), song.getGenre(), song.getDuration());

            }
            System.out.println("+--------------------------------------------------------------------------------------------------------------+");
        }
        public static ArrayList<song> displayPlaylist(String play) throws SQLException {
            ArrayList<song>list=new ArrayList<>();
            ArrayList<song> songslist = Details.songs();
            Connection connection = getConnection.connectTo();
            Playlist playlist = null;
            String songs = "";
            Iterator<song> i= songslist.iterator();
            Statement st = connection.createStatement();
            song song = null;
            ResultSet rs = st.executeQuery("select * from playlist");
            ArrayList<Integer>songId=new ArrayList<>();
            while (rs.next()) {
                if (rs.getString(1).equals(play)){
                    songId.add(rs.getInt(2));

                }
            }

            int it=songId.size();
            System.out.println(it);
            while (i.hasNext()){
                song=i.next();
                for (int x=0;x<=it-1;x++){
                    if (song.getSongId()==songId.get(x)){
                        list.add(song);
                    }
                }
            }
            return list;
        }
    }

