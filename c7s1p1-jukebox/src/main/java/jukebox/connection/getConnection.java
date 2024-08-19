package jukebox.connection;
import jukebox.exception.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
public class getConnection {
    public static Connection connectTo()
    {
        Connection connection= null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blissmusic","root","1234");

        } catch (ClassNotFoundException | java.sql.SQLException e)
        {
            System.out.println(e);

        }
        return connection;
    }

}
