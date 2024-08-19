package jukebox.DAOImpl;
import java.sql.SQLException;
import java.util.*;
import static jukebox.DAOImpl.main.mainMenu;

public class musicImpl {
    public static void main(String[] args) throws SQLException {
        musicImpl s = new musicImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.format(" %90s ","Bliss Music");
        System.out.println("");
        System.out.println("");
        System.out.format( " %100s " ," Your personalised Audio Jukebox" );
        System.out.println("");
        System.out.println("");
        mainMenu();
        System.out.println("");
        System.out.format(" %100s ","Thanks For Listing this BlissMusic");

    }
}
