package jukebox.DAOImpl;

import jukebox.connection.getConnection;
import jukebox.model.Playlist;
import jukebox.model.song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Details {
    public static ArrayList<song> songs() {

        Connection connection = getConnection.connectTo();
        ArrayList<song> list = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs");
            while (rs.next()) {
                song song = new song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getFloat(5), rs.getString(6));
                list.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<song> Searchsong(String Song) {
        getConnection con = new getConnection();
        Connection connection = con.connectTo();
        ArrayList<song> search = new ArrayList<>();
        song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where songTitle='" + Song + "';");
            while (rs.next()) {
                song = new song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),   rs.getFloat(5), rs.getString(6));
                search.add(song);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return search;
    }

    public static ArrayList<song> SearchByGenre(String Song) {
        getConnection con = new getConnection();
        Connection connection = con.connectTo();
        ArrayList<song> search = new ArrayList<>();
        song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where genre='" + Song + "';");
            while (rs.next()) {
                song = new song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),   rs.getFloat(5), rs.getString(6));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }

    public static ArrayList<song> SearchByArtist(String Song) {
        getConnection con = new getConnection();
        Connection connection = con.connectTo();
        ArrayList<song> search = new ArrayList<>();
        song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where artistName='" + Song + "';");
            while (rs.next()) {
                song = new song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getFloat(5), rs.getString(6));
                search.add(song);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return search;
    }
    public static ArrayList<Playlist> viewAllPlaylist() {    //arraylist user is return type
        getConnection connect = new getConnection();
        Connection connection = connect.connectTo();
        ArrayList<Playlist> list = new ArrayList<>();
        Playlist playlist = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist");
            while (rs.next()) {
                playlist = new Playlist(rs.getInt(1), rs.getString(2),rs.getString(3));
                list.add(playlist);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static void viewPlaylist() {
        String playlistName = "";
        getConnection connect = new getConnection();
        Connection connection = connect.connectTo();
        ArrayList<Playlist> list = new ArrayList<>();
        Playlist playlist = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist");
            System.out.println("All playlist Names :");
            while (rs.next()) {
                if (!playlistName.equals(rs.getString(1))) {
                    System.out.println(rs.getString(1));
                }
                playlistName = rs.getString(1);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

