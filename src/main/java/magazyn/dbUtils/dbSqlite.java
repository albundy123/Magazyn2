package magazyn.dbUtils;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.sql.SQLException;

public class dbSqlite {

    private final static String DATABASE_URL = "jdbc:sqlite:C:/db/baza1.db";
    private static ConnectionSource connectionSource;

    public static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
            System.out.println("Udało się połączyć z bazą danych");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }
    public static void closeConnection(){
        if(connectionSource != null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
