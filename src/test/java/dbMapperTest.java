import entities.user;
import entities.database;
import model.Database;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class dbMapperTest
{
    private final static String DATABASE = "startcode_test";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE /*+ "_test"*/;
    private final static String USER = "dev";
    private final static String PASSWORD = "ax2";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET";
    private static database dbTest = new database(USER, PASSWORD, URL);
   // private static database db = new database("dev", "ax2", "jdbc:mysql://localhost:3306/startcode?serverTimezone=CET" );
    private static Database database;
    private static model.dbMapper dbMapper;

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }
    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection(dbTest.getURL(), dbTest.getUSER(), dbTest.getPW() );
        }
        return singleton;
    }

    @BeforeAll
public static void setUp() throws SQLException, ClassNotFoundException
    {
        setConnection(connection());
}



    @Test
    public void testSetup() throws SQLException, ClassNotFoundException
    {

        assertNotNull(singleton);
    }

   @Test
    public void seeAllUsers() {
   List<user> users = model.dbMapper.seeAllUsers(dbTest);
       assertEquals("Henning", users.get(0).getfName());
       assertEquals("Dahl", users.get(0).getlName());
    }

    @Test
    public void seeSpecificUser() {
        user specificUser = model.dbMapper.seeSpecificUser("Henning", "Dahl");
        assertEquals("Henning", specificUser.getfName());
        assertEquals("Dahl", specificUser.getlName());
        assertEquals("sdfw333", specificUser.getPassword());
        assertEquals("+4540949403", specificUser.getPhoneNumber());
        assertEquals("Rolighedsvej 22, 2100 Kbh Ø", specificUser.getAddress());
    }
}
