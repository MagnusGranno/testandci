package model;


        import entities.database;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;


public class Database {
    private static String URL  = "jdbc:mysql://localhost:3306/startcode?serverTimezone=CET";
    private static String USER = "dev";
    private static String PW = "ax2";
    private static String Driver = "com.mysql.cj.jdbc.Driver";

    private static database db = new database(USER, PW, URL);
    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection(database db) throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( db.getURL(), db.getUSER(), db.getPW());
        }
        return singleton;
    }

    public static database getDb()
    {
        return db;
    }
}
