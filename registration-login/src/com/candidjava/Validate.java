package com.candidjava;

import java.sql.*;

public class Validate {
    public static boolean checkUser(String userid,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","eva324751997");
            PreparedStatement ps = con.prepareStatement("select * from users where userid=? and password=?");
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
