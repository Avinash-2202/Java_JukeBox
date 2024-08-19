package jukebox.DAOImpl;
import jukebox.connection.getConnection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

 public class createPlaylist
        {
    public static boolean createSongs(String playlistname, int songsId ) throws SQLException {
        Connection con= getConnection.connectTo();
        boolean insert = true;
        try{
            Statement st= con.createStatement();
            insert=st.execute("insert into playlist(playlistname,songsId) values('"+playlistname+"' ,"+songsId+");");

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return insert;
    }
}
