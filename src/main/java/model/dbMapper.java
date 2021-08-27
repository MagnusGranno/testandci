package model;

import entities.database;
import entities.user;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class dbMapper
{

    private static database db = Database.getDb();

    public static List<user> seeAllUsers(database db) {
        List<user> users = new ArrayList<>();

        try {
            Connection con = Database.connection(db);
            String sql = "SELECT * FROM usertable";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fName = rs.getString("fname");
                String lName = rs.getString("lname");
                String pw = rs.getString("pw");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                users.add(new user(fName, lName, pw, phone, address));

            }
        } catch(SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public static user seeSpecificUser(String firstName, String lastName) {
        user specificUser = new user();
        try {
            Connection con = Database.connection(db);
            String sql = "SELECT * FROM usertable WHERE fname=? AND lname=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String fName = rs.getString("fname");
                String lName = rs.getString("lname");
                String pw = rs.getString("pw");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                specificUser.setfName(fName);
                specificUser.setlName(lName);
                specificUser.setPassword(pw);
                specificUser.setPhoneNumber(phone);
                specificUser.setAddress(address);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return specificUser;
    }




    public static void main(String[] args)
    {
        List<user> users = seeAllUsers(db);
        for(user user : users)
        {
            System.out.println(user.getfName() + " " + user.getlName());
        }
        user specificUser = seeSpecificUser("Henning", "Dahl");
        System.out.println(specificUser.toString());
    }

}